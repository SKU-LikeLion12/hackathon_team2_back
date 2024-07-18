package com.example.simple_project_back.DTO;

import lombok.Data;

public class MemberDTO {
    @Data
    public static class LoginRequest{
        private String userId;
        private String password;
    }


}
