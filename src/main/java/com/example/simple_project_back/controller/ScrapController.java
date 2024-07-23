package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.FavoriteDTO;
import com.example.simple_project_back.DTO.ScrapDTO;
import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Favorite;
import com.example.simple_project_back.domain.Scrap;
import com.example.simple_project_back.service.ScrapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScrapController {
    private final ScrapService scrapService;

    @PostMapping("/scrap/add")
    public ResponseEntity<String> addScrap(@RequestBody ScrapDTO.ScrapRequest request){
        try{
            if( scrapService.toggleScrap(request) == 1){
                return ResponseEntity.status(HttpStatus.CREATED).body("success");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
    }


    @GetMapping("/scrap/myPage")
    public List<WellnessDTO.WellnessResponse> getScrapMyPage(@RequestBody ScrapDTO.ScrapMemberRequest request){
        List<WellnessDTO.WellnessResponse> responses = new ArrayList<>();
        for( Scrap s : scrapService.getScrapByUserId( request)){
            responses.add(new WellnessDTO.WellnessResponse( s.getWellness()));
        }
        return responses;
    }




}
