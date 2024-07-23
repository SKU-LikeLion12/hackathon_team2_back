package com.example.simple_project_back.repository;


import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaWellnessRepository implements WellnessRepository {
    private final EntityManager em;

    @Override
    public List<Wellness> findWellnessAll() {
        return em.createQuery("select w from Wellness w order by w.favoriteCnt", Wellness.class)
                .getResultList();
    }


    @Override
    public List<Wellness> findWellnessByTheme(Long themeId) {
        return  em.createQuery("select w from Wellness w  where w.theme = :themeId order by w.favoriteCnt", Wellness.class)
                .setParameter("themeId", themeId)
                .getResultList();
    }

    @Override
    public Wellness findWellnessById(Long wellnessId) {
        try{
            return em.createQuery("select w from Wellness w where w.id = :wellnessId", Wellness.class)
                    .setParameter("wellnessId", wellnessId).getSingleResult();

        }catch (NoResultException e){

            return null;
        }
    }


    @Override
    public Wellness addWellness(Wellness wellness) {
        try{
            em.persist(wellness);
            return wellness;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public void updateFavoriteCnt(Wellness wellness, Long delta) {
        em.createQuery("UPDATE Wellness w SET w.favoriteCnt = w.favoriteCnt + :delta WHERE w.id = :wellnessId")
                .setParameter("delta", delta)
                .setParameter("wellnessId", wellness.getId())
                .executeUpdate();
    }
}
