package com.example.simple_project_back.service;


import com.example.simple_project_back.DTO.MemberDTO;
import com.example.simple_project_back.domain.Member;
import com.example.simple_project_back.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;
    private final JwtUtility jwtUtility;


    @Transactional
    public Member signUp(MemberDTO.signUpRequest request){
        Member member = memberRepository.findByUserId(request.getUserId());
        if (member != null){ // 이미 있음
            return null;
        }
        return memberRepository.save(new Member(request.getUserId(), request.getPassword(), request.getNickName(), request.getEleMail()));
    }


    @Transactional
    public String login(String userId, String password) {
        Member member = memberRepository.findByUserId(userId);
        if (member != null && member.checkPassword(password)) {
            return jwtUtility.generateToken(member.getUserId());
        }
        return null;
    }

    public Member tokenToMember(String token){
        return memberRepository.findByUserId(jwtUtility.validateToken(token).getSubject());
    }

}
