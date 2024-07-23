package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Scrap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JapScrapRepository implements ScrapRepository {
    public final EntityManager em;

    @Override
    public int toggleScrap(Scrap scrap) {
        try{
            em.remove(
                    em.createQuery("select s from Scrap s where s.member =:member and s.wellness = :wellness", Scrap.class)
                    .setParameter("member", Scrap.getMember())
                    .setParameter("wellness", Scrap.getWellness())
                    .getSingleResult()
            );
            return 0;
        }catch (NoResultException e){
            em.persist(Scrap);
            return 1;
        }
    }



}
