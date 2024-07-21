package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Member findByUserId(String userId) {
        try{
            return em.createQuery("select m from Member m where m.userId = :userId",Member.class)
                    .setParameter("userId", userId).getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }


}
