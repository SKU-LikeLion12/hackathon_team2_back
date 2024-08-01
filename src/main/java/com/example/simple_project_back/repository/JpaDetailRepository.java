package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Detail;
import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class JpaDetailRepository implements DetailRepository{
    private final EntityManager em;

    @Override
    public void addDetail(Detail detail) {
        em.persist(detail);
    }

    @Override
    public Detail findDetailById(Long wellnessId) {
        try{
            return em.createQuery("select d from Detail d where d.wellness.id = :wellnessId", Detail.class)
                    .setParameter("wellnessId", wellnessId)
                    .getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
