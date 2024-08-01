package com.example.simple_project_back.service;

import com.example.simple_project_back.DTO.WellnessDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {
    private final WellnessService wellnessService;
    private final ObjectMapper objectMapper;

    @Transactional
    public void loadData(){

        System.out.println(1);

        try {
            // JSON 파일을 읽습니다.
            ClassPathResource resource = new ClassPathResource("resource/basicData.json");
            List<WellnessDTO.WellnessRequest> wellnessRequests = objectMapper.readValue(resource.getInputStream(),
                    new TypeReference< List<WellnessDTO.WellnessRequest> >() {});

            System.out.println(wellnessRequests);

            // 서비스 메서드를 호출하여 데이터를 처리합니다.
            addData(wellnessRequests);

        } catch (IOException e) {

        }

    }

    @Transactional
    public void addData(List<WellnessDTO.WellnessRequest> request) {
        // DTO 객체를 이용하여 필요한 로직을 처리합니다.
        for (WellnessDTO.WellnessRequest w : request) {
            // 예: 데이터베이스에 저장하는 로직
            wellnessService.setWellness((w));
            System.out.println(1);
        }
    }
}
