package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.FavoriteDTO;
import com.example.simple_project_back.DTO.ScrapDTO;
import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.domain.Scrap;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.ScrapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ScrapService {
    private final ScrapRepository scrapRepository;
    private final MemberService memberService;
    private final WellnessService wellnessService;


    @Transactional
    public int toggleScrap(ScrapDTO.ScrapRequest request){
        Member member = memberService.tokenToMember(request.getToken());
        Wellness wellness = wellnessService.getWellnessById(request.getWellnessId());
        if( scrapRepository.toggleScrap(new Scrap(member, wellness)) == 1){
            return 1;
        }else{
            return 0;
        }

    }
    public List<Scrap> getScrapByUserId(ScrapDTO.ScrapMemberRequest request){
        Member member = memberService.tokenToMember(request.getToken() );
        return scrapRepository.findAllById( member);
    }


}
