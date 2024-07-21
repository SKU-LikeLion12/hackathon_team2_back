package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Member;

import java.util.List;

public interface MemberRepository {
    
    // 회원가입
    Member save(Member member);

    // 사용자 테이블에 있는지 리턴
    Member findByUserId(String userId);


}
