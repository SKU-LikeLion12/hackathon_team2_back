package com.example.simple_project_back.DTO;

import lombok.Data;

public class FavoriteDTO {

    @Data
    public static class FavoriteRequest{
        private String token;
        private Long wellnessId;
    }

    @Data
    public static class FavoriteMemberRequest{
        private String token;
    }


}
