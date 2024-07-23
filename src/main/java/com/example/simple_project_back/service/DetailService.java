package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.DetailDTO;
import com.example.simple_project_back.domain.Detail;
import com.example.simple_project_back.domain.Wellness;
import com.example.simple_project_back.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DetailService {
    private final DetailRepository detailRepository;


    @Transactional
    public void setDetail(DetailDTO.DetailRequest request, Wellness wellness){
        detailRepository.addDetail( new Detail(request.getIntroduce(),request.getHp(), request.getAddress(),
                                   request.getUrl(), request.getWorkTime(), request.getTitle(),
                                   request.getLati(), request.getHard(), wellness) ) ;


    }


    public Detail getDetail(DetailDTO.DetailGetRequest request){
        return detailRepository.findDetailById(request.getWellnessId());
    }


}
