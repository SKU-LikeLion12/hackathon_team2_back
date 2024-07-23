package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Detail;
import com.example.simple_project_back.domain.Wellness;

public interface DetailRepository {


    void addDetail(Detail detail);

    // 상세 페이지 불러오기
    Detail findDetailById(Long wellnessId);
}
