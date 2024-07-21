package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface WellnessRepository {

    // 메인페이지
    List<Wellness> findWellnessAll();
    
    // 상세페이지 댓글 가져오기
    Wellness findWellnessById(Long wellnessId);
}
