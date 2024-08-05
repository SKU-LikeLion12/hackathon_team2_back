package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.ScrapDTO;
import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Scrap;
import com.example.simple_project_back.service.ScrapService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScrapController {
    private final ScrapService scrapService;

    @Operation(summary = "스크랩하기", description = "사용자가 원하는 매장 스크랩 하기", tags = {"Member"})
    @PostMapping("/scrap/add")
    public ResponseEntity<String> addScrap(@RequestBody ScrapDTO.ScrapRequest request){
        try{
            if( scrapService.toggleScrap(request) == 1){
                return ResponseEntity.status(HttpStatus.CREATED).body("success");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("delete");
    }


    @Operation(summary = "사용자가 스크랩한 매장들 보기", description = "사용자가 스크랩한 매장 불러오기", tags = {"Member"})
    @PostMapping("/scrap/myPage")
    public List<WellnessDTO.WellnessResponse> getScrapMyPage(@RequestBody ScrapDTO.ScrapMemberRequest request){
        List<WellnessDTO.WellnessResponse> responses = new ArrayList<>();
        for( Scrap s : scrapService.getScrapByUserId( request)){
            responses.add(new WellnessDTO.WellnessResponse( s.getWellness()));
        }
        return responses;
    }




}
