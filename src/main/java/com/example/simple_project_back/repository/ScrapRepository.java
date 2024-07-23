package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Scrap;

import java.util.List;

public interface ScrapRepository {

    // 좋아요
    int toggleScrap(Scrap scrap);

    // 마이페이지 > 스크랩(좋아요) 기능
    List<Scrap> findAllById(Member member);


}
