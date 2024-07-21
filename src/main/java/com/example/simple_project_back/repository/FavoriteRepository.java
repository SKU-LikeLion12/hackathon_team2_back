package com.example.simple_project_back.repository;


import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;

import java.util.List;

public interface FavoriteRepository {
    
    // 좋아요
    int addFavorite(Favorite favorite);

    // 마이페이지 > 스크랩(좋아요) 기능
    List<Favorite> findAllById(Member member);
}


