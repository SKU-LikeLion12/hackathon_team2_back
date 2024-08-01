package com.example.simple_project_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/load-date")
    public String loadDate() {
        try {
            // 리소스 파일 경로 설정
            Path path = Paths.get(new ClassPathResource("basicData.json").getURI());

            // 파일을 문자열로 읽기
            String jsonContent = Files.readString(path);

            // JSON 데이터 처리
            memberService.processJsonData(jsonContent);

            return new ResponseEntity<>("Data loaded successfully", HttpStatus.OK);
        } catch (IOException | IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to load data", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



}
