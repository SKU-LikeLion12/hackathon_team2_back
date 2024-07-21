package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.MemberDTO;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;


    @PostMapping("/member/signUp")
    public ResponseEntity<String> signUp(@RequestBody MemberDTO.SignUpRequest request) {

        Member member = memberService.signUp(request);
        if(member == null) {
            String message = "이미 존재하는 회원입니다.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        String token = memberService.login(request.getUserId(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }

    @PostMapping("/member/login")
    public ResponseEntity<String>  login(@RequestBody MemberDTO.LoginRequest request) {
        String token = memberService.login(request.getUserId(), request.getPassword());
        if (token == null) {
            String message = "잘못된 로그인입니다.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(token);
    }




}
