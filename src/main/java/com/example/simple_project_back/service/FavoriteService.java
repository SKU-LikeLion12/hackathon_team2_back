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

            if (favoriteRepository.toggleFavorite(new Favorite(member, wellness)) == 1){
                wellnessService.updateFavoriteCnt( wellness, 1L); // 생성되었다는 것은 +1을 해줘야 한다는 것
                return 1;
            }else{
                wellnessService.updateFavoriteCnt( wellness, -1L);
                return 0;
            }

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
