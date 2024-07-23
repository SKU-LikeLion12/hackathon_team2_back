package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.WellnessService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WellnessController {
    private final WellnessService wellnessService;

    @Operation(summary = "메인 페이지 보기", description = "메인 페이지에 모든 매장 보여주기", tags = {"HomePage"})
    @GetMapping("/mainPage")
    public List<WellnessDTO.WellnessResponse> getMainPage(){
        List<WellnessDTO.WellnessResponse> response = new ArrayList<>();
        for( Wellness w : wellnessService.getWellness() ){
            response.add(new WellnessDTO.WellnessResponse(w));
        }
        return response;
    }

    @Operation(summary = "테마별 매장 보기", description = "테마에 해당하는 매장 보여주기", tags = {"HomePage"})
    @GetMapping("/themePage/{themeId}")
    public List<WellnessDTO.WellnessResponse> themePage(@PathVariable Long themeId){
        List<WellnessDTO.WellnessResponse> response = new ArrayList<>();
        for( Wellness w : wellnessService.getWellnessByTheme(themeId) ){
            response.add(new WellnessDTO.WellnessResponse(w));
        }
        return response;
    }


    @Operation(summary = "운영자가 새로운 매장 추가하기", description = "새로운 매장에 대한 정보를 받아 추가", tags = {"admin"})
    @PostMapping("/wellness/add")
    public ResponseEntity<String> setWellness(@RequestBody WellnessDTO.WellnessRequest request) {
        if( wellnessService.setWellness(request) == 1){
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }

}
