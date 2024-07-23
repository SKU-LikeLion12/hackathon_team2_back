package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.WellnessService;
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

    @GetMapping("/mainPage")
    public List<WellnessDTO.WellnessResponse> getMainPage(){
        List<WellnessDTO.WellnessResponse> response = new ArrayList<>();
        for( Wellness w : wellnessService.getWellness() ){
            response.add(new WellnessDTO.WellnessResponse(w));
        }
        return response;
    }

    @GetMapping("/themePage/{themeId}")
    public List<WellnessDTO.WellnessResponse> themePage(@PathVariable Long themeId){
        List<WellnessDTO.WellnessResponse> response = new ArrayList<>();
        for( Wellness w : wellnessService.getWellnessByTheme(themeId) ){
            response.add(new WellnessDTO.WellnessResponse(w));
        }
        return response;
    }




    @PostMapping("/wellness/add")
    public ResponseEntity<String> setWellness(@RequestBody WellnessDTO.WellnessRequest request) {
        if( wellnessService.setWellness(request) == 1){
            return ResponseEntity.status(HttpStatus.OK).body("success");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }

}
