package com.example.simple_project_back.controller;


import com.example.simple_project_back.DTO.MemberDTO;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;



    @Operation(summary = "회원가입", description = "회원가입 후 로그인", tags={"Basic"})
    @PostMapping("/member/signUp")
    public MemberDTO.LoginResponse signUp(@RequestBody MemberDTO.SignUpRequest request) {
        Member member = memberService.signUp(request);
        if(member == null) {
            return new MemberDTO.LoginResponse( "fail", 0, "fail");
        }
        return memberService.login(request.getUserId(), request.getPassword());
    }

    @Operation(summary = "사용자로그인", description = "로그인 기능", tags = {"Basic"})
    @PostMapping("/member/login")
    public  MemberDTO.LoginResponse login(@RequestBody MemberDTO.LoginRequest request) {
        try{
            return memberService.login(request.getUserId(), request.getPassword());
        }catch (Exception e) {
            return new MemberDTO.LoginResponse( "fail", -1, "fail");
        }
    }


    @Operation(summary = "사장님 회원가입", description = "사장님회원가입 기능", tags = {"Owner"})
    @PostMapping("/member/SignUpOwnerRequest")
    public ResponseEntity<String> signUpOwner(@RequestBody MemberDTO.SignUpOwnerRequest request) {
        Member member = memberService.signUpOwner(request);
        if(member == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

}