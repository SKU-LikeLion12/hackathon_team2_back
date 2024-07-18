package com.example.simple_project_back.repository;


import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class WellnessRepository implements WellnessInterface{
    private final EntityManager em;

    @Override
    public Wellness FindById(Long WellnessId) {
        return em.find(Wellness.class, WellnessId);
    }

    @Override
    public Wellness SaveWellness(Wellness wellness) {
        em.persist(wellness);
        return wellness;
    }

    @Override
    public void DeleteWellness(Wellness wellness) {
        em.remove(wellness);
    }

    @Override
    public Wellness FindByLocation(String location) {
        return em.createQuery("select w from Wellness w where w.Location = :l", Wellness.class)
                .setParameter("l", location).getSingleResult();
    }

    @Override
    public Wellness FindByThema(String thema) {
        return em.createQuery("select w from Wellness w where w.Thema = :t",Wellness.class)
                .setParameter("t", thema).getSingleResult();
    }

    @Override
    public Wellness FindByTitle(String title) {
        return em.createQuery("select w from Wellness w where w.Title = :ti",Wellness.class)
                .setParameter("ti", title).getSingleResult();
    }

    @Override
    public Wellness FindByFavorite(Long favoriteCnt) {
        return em.createQuery("select w from Wellness w where w.FavoriteCount = :fc",Wellness.class)
                .setParameter("fc", favoriteCnt).getSingleResult();
    }

    @Override
    public List<Wellness> FindAllWellness() {
        return em.createQuery("select w from Wellness w", Wellness.class).getResultList();
    }
}
