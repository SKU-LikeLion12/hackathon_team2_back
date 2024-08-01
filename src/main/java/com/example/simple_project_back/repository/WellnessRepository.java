package com.example.simple_project_back.repository;

import com.example.simple_project_back.domain.Wellness;

import java.util.List;

public interface WellnessRepository {

    // 메인페이지
    List<Wellness> findWellnessAll();

    // 테마 페이지
    List<Wellness> findWellnessByTheme(Long themeId);

    // 상세페이지 댓글 가져오기에 필요함
    Wellness findWellnessById(Long wellnessId);

    // 웰니스 페이지 추가( 이 때 상세 페이지 정해야한다.)
    Wellness addWellness(Wellness wellness);

    // 즐겨찾기 토글작동 후 증가, 혹은 감소
    void updateFavoriteCnt(Wellness wellness, Long delta);
}
