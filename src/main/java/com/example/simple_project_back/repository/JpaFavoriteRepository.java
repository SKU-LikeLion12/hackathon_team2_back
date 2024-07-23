package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaFavoriteRepository implements FavoriteRepository {
    private final EntityManager em;

    @Override
    public int toggleFavorite(Favorite favorite) {
        try{

            em.remove(
                    em.createQuery("select f from Favorite f where f.member = :member and f.wellness = :wellness", Favorite.class )
                    .setParameter("member", favorite.getMember())
                    .setParameter("wellness", favorite.getWellness())
                    .getSingleResult()
            );
            return 0;

        }catch (NoResultException e){
            em.persist(favorite);
            return 1;
        }
    }


    @Override
    public List<Favorite> findAllById(Member member) {
        return em.createQuery("select f from Favorite f where f.member =:member", Favorite.class)
                .setParameter("member", member)
                .getResultList();
    }
}
