package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.FavoriteDTO;
import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final MemberService memberService;
    private final WellnessService wellnessService;


    @Transactional
    public int toggleFavorite(FavoriteDTO.FavoriteRequest request){
        try {
            Member member = memberService.tokenToMember(request.getToken());
            Wellness wellness = wellnessService.getWellnessById(request.getWellnessId());
            return favoriteRepository.addFavorite(new Favorite(member, wellness));
            // 삭제 0, 추가 1, 오류 2
        }catch (Exception e){
            return 2;
        }
    }


    public List<Favorite> getFavoriteByUserId(FavoriteDTO.FavoriteMemberRequest request){
        Member member = memberService.tokenToMember(request.getToken() );
        return favoriteRepository.findAllById( member);
    }


}
