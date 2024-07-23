package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.DetailDTO;
import com.example.simple_project_back.service.DetailService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DetailController {
    private final DetailService detailService;


    @Operation(summary = "상세 페이지 불러오기", description = "상세 페이지 정보 가져오기", tags = {"HomePage"})
    @GetMapping("/detail/get")
    public DetailDTO.DetailResponse getDetail(@RequestBody DetailDTO.DetailGetRequest request){

        try{
            return new DetailDTO.DetailResponse( detailService.getDetail(request) );
        }catch (Exception e){
            return null;
        }
    }

}
