package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.DetailDTO;
import com.example.simple_project_back.service.DetailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DetailController {
    private final DetailService detailService;


    @Operation(summary = "상세 페이지 불러오기", description = "상세 페이지 정보 가져오기", tags = {"HomePage"})
    @GetMapping("/detail/get/{wellnessId}")
    public DetailDTO.DetailResponse getDetail(@PathVariable("wellnessId") Long wellnessId){

        try{
            return new DetailDTO.DetailResponse( detailService.getDetail(wellnessId) );
        }catch (Exception e){
            return null;
        }
    }

}
