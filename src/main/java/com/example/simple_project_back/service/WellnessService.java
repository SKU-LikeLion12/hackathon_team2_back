package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.WellnessDTO;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.WellnessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WellnessService {
    private final WellnessRepository wellnessRepository;


    public List<Wellness> getWellness(){
        return wellnessRepository.findWellnessAll();
    }

    public Wellness getWellnessById(Long wellnessId){
        return wellnessRepository.findWellnessById(wellnessId);
    }


    @Transactional
    public int setWellness(WellnessDTO.WellnessRequest request){
        return wellnessRepository.addWellness(new Wellness(request.getLocation(), request.getTheme(), request.getTitle()) );


    }


}
