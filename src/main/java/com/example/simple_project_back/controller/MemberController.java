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
    public MemberDTO.LoginResponse signUp(@RequestBody MemberDTO.SignUpRequest request) {

        Member member = memberService.signUp(request);
        if(member == null) {
            return new MemberDTO.LoginResponse( "fail", -1L);
        }
        return memberService.login(request.getUserId(), request.getPassword());
    }

    @PostMapping("/member/login")
    public  MemberDTO.LoginResponse login(@RequestBody MemberDTO.LoginRequest request) {
        try{
            return memberService.login(request.getUserId(), request.getPassword());
        }catch (Exception e) {
            return new MemberDTO.LoginResponse( "fail", -1L);
        }
    }


}
