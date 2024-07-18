package com.example.simple_project_back.controller;

import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.WellnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class WellnessController {
    private final WellnessService wellnessService;


    @PostMapping("/Wellness/add")
    public WellnessDTO.WellnessResponse SaveWellness(@RequestBody WellnessDTO.WellnessRequest request) {
        Wellness wellness = wellnessService.SaveWellness(request.getLocation(), request.getThema(), request.getTitle());
        return new WellnessDTO.WellnessResponse(wellness);
    }
}
