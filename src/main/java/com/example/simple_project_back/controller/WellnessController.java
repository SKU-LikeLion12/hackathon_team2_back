package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.WellnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class WellnessController {
    private final WellnessService wellnessService;

    @GetMapping("/mainPage")
    public List<WellnessDTO.ResponseWellness> getMainPage(){
        List<WellnessDTO.ResponseWellness> response = new ArrayList<>();
        for( Wellness w : wellnessService.getWellness() ){
            response.add(new WellnessDTO.ResponseWellness(w));
        }
        return response;
    }

    


}
