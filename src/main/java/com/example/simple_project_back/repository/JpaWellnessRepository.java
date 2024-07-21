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
    public Wellness findWellnessById(Long wellnessId) {
        try{
            return em.createQuery("select w from Wellness w where w.id = :wellnessId", Wellness.class)
                    .setParameter("wellnessId", wellnessId).getSingleResult();

        }catch (NoResultException e){

            return null;
        }
    }


    @Override
    public int addWellness(Wellness wellness) {
        try{
            em.persist(wellness);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
