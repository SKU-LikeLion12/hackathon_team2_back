package com.example.simple_project_back.controller;

import com.example.simple_project_back.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainService mainService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/load-data")
    @ResponseBody
    public String loadData() {
        mainService.loadData();
        return "<html><body><h1>Data loaded successfully!</h1><a href=\"/\">Go to Home</a></body></html>";
    }
}
