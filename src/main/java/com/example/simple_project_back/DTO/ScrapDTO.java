package com.example.simple_project_back.DTO;

import lombok.Data;

public class ScrapDTO {

    @Data
    public static class ScrapRequest{
        private String token;
        private Long wellnessId;
    }

    @Data
    public static class ScrapMemberRequest{
        private String token;
    }


}
