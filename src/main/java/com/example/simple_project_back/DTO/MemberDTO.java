package com.example.simple_project_back.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

public class MemberDTO {

    // 로그인 서버 응답시 필요한 데이터
    @Data
    public static class LoginResponse {
        private String token;
        private int isOwner;

        public LoginResponse(String token, int isOwner) {
            this.token = token;
            this.isOwner = isOwner;
        }
    }

    // 로그인 사용자 요청시 필요한 데이터
    @Data
    public static class LoginRequest{
        @Schema(description = "아이디", example = "test_id")
        private String userId;
        @Schema(description = "비밀번호", example = "test_pwd")
        private String password;
    }

    // 회원가입 일반 사용자 요청시 필요한 데이터
    @Data
    public static class SignUpRequest {
        @Schema(description = "아이디", example = "test_id")
        private String userId;
        @Schema(description = "비밀번호", example = "test_pwd")
        private String password;
        @Schema(description = "닉네임", example = "test_nickname")
        private String nickName;
        @Schema(description = "이메일", example = "test_eMail")
        private String eleMail;
    }


    // 회원가입 사장 사용자 요청시 필요한 데이터
    @Data
    public static class SignUpOwnerRequest {
        @Schema(description = "아이디", example = "test_id")
        private String userId;
        @Schema(description = "비밀번호", example = "test_pwd")
        private String password;
        @Schema(description = "닉네임", example = "test_nickname")
        private String nickName;
        @Schema(description = "이메일", example = "test_eleMail")
        private String eleMail;
        @Schema(description = "이메일", example = "test_eMail")
        private Long managerId;

    }
}
