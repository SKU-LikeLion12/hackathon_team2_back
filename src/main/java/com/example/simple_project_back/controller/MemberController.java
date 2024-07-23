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


    // 회원가입 컨트롤러
    @PostMapping("/member/signUp")
    public MemberDTO.LoginResponse signUp(@RequestBody MemberDTO.SignUpRequest request) {

        Member member = memberService.signUp(request);
        if(member == null) {
            return new MemberDTO.LoginResponse( "fail", -1);
        }
        return memberService.login(request.getUserId(), request.getPassword());
    }

    // 로그인 컨트롤러
    @PostMapping("/member/login")
    public  MemberDTO.LoginResponse login(@RequestBody MemberDTO.LoginRequest request) {
        try{
            return memberService.login(request.getUserId(), request.getPassword());
        }catch (Exception e) {
            return new MemberDTO.LoginResponse( "fail", -1);
        }
    }


    // 사장 회원가입 컨트롤러
    @PostMapping("/member/SignUpOwnerRequest")
    public ResponseEntity<String> signUpOwner(@RequestBody MemberDTO.SignUpOwnerRequest request) {
        Member member = memberService.signUpOwner(request);
        if(member == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }
    //Post, Get, Put, Delet
}