package com.example.simple_project_back.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

public class MemberDTO {
    @Data
    public static class LoginResponse {
        private String nickName;
        private String token;
        private int isOwner;

        public LoginResponse(String token, int isOwner, String nickName) {
            this.token = token;
            this.isOwner = isOwner;
            this.nickName = nickName;
        }
    }

    @Data
    public static class LoginRequest{
        @Schema(description = "아이디", example = "test_id")
        private String userId;
        @Schema(description = "비밀번호", example = "test_pwd")
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
        @Schema(description = "매장id", example = "test_eMail")
        private Long managerId;

    }

    @Data
    public static class OverLapRequest{
        @Schema(description = "아이디", example = "test_id")
        private String userId;
    }


}
