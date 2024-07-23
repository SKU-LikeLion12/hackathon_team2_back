package com.example.simple_project_back.repository;


import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Scrap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaScrapRepository implements ScrapRepository {
    private final EntityManager em;


    @Override
    public int toggleScrap(Scrap scrap) {
        try{

            em.remove(
                    em.createQuery("select s from Scrap s where s.member = :member and s.wellness = :wellness", Scrap.class )
                            .setParameter("member", scrap.getMember())
                            .setParameter("wellness", scrap.getWellness())
                            .getSingleResult()
            );
            return 0;

        }catch (NoResultException e){
            em.persist(scrap);
            return 1;
        }
    }


    @Override
    public List<Scrap> findAllById(Member member) {
        return em.createQuery("select s from Scrap s where s.member =:member", Scrap.class)
                .setParameter("member", member)
                .getResultList();
    }
}
