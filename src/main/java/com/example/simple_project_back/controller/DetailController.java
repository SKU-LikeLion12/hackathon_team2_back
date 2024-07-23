package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.DetailDTO;
import com.example.simple_project_back.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DetailController {
    private final DetailService detailService;


    @GetMapping("/detail/get")
    public DetailDTO.DetailResponse getDetail(@RequestBody DetailDTO.DetailGetRequest request){

        try{
            return new DetailDTO.DetailResponse( detailService.getDetail(request) );
        }catch (Exception e){
            return null;
        }
    }

}
