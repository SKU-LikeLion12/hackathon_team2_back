package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.DetailDTO;
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
    private final DetailService detailService;


    public List<Wellness> getWellness(){
        return wellnessRepository.findWellnessAll();
    }


    public List<Wellness> getWellnessByTheme(Long themeId){
        return wellnessRepository.findWellnessByTheme(themeId);
    }


    public Wellness getWellnessById(Long wellnessId){
        return wellnessRepository.findWellnessById(wellnessId);
    }


    @Transactional
    public int setWellness(WellnessDTO.WellnessRequest request){
        Wellness wellness = wellnessRepository.addWellness(new Wellness(request.getLocation(), request.getTheme(), request.getTitle()) );
        if(wellness != null){
            detailService.setDetail(new DetailDTO.DetailRequest(request), wellness);
            return 1;
        }
        return 0;
    }


    @Transactional
    public void updateFavoriteCnt(Wellness wellness, Long delta){
        wellnessRepository.updateFavoriteCnt(wellness, delta);
    }



}
