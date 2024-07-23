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

    // 회원가입 회원 저장
    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    // 로그인 사용자 ID찾기
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
