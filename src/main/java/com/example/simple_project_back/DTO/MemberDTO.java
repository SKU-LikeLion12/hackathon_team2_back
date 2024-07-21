package com.example.simple_project_back.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

public class MemberDTO {
    @Data
    public static class LoginResponse {
        private String token;
        private Long isOwner;

        public LoginResponse(String token, Long isOwner) {
            this.token = token;
            this.isOwner = isOwner;
        }
    }

    @Data
    public static class LoginRequest{
        private String userId;
        private String password;
    }

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


}
