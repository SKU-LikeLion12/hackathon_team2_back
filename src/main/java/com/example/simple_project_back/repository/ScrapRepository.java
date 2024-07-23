package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Scrap;

import java.util.List;


public interface ScrapRepository {

    // 스크랩
    int toggleScrap(Scrap scrap);

    // 마이페이지 > 스크랩 기능
    List<Scrap> findAllById(Member member);
}
