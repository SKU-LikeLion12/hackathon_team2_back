package com.example.simple_project_back.controller;

import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.service.WellnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class WellnessController {
    private final WellnessService wellnessService;


    @PostMapping("/Wellness/add")
    public WellnessDTO.WellnessResponse SaveWellness(@RequestBody WellnessDTO.WellnessRequest request) {
        Wellness wellness = wellnessService.SaveWellness(request.getLocation(), request.getThema(), request.getTitle());
        return new WellnessDTO.WellnessResponse(wellness);
    }

    @GetMapping("/Wellness/location")
    public WellnessDTO.WellnessResponse FindByLocation(@RequestBody WellnessDTO.WellnessRequest request) {
        Wellness wellness = wellnessService.FindByLocation(request.getLocation());
        return new WellnessDTO.WellnessResponse(wellness);
    }

    @GetMapping("/Wellness/Thema")
    public WellnessDTO.WellnessResponse FindByThema(@RequestBody WellnessDTO.WellnessRequest request) {
        Wellness wellness = wellnessService.FindByThema(request.getThema());
        return new WellnessDTO.WellnessResponse(wellness);
    }
}
