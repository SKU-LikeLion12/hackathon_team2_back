package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Wellness;
import jakarta.persistence.Column;
import lombok.Data;

public class WellnessDTO {
    @Data
    public static class WellnessResponse {
        private long WellnessId;
        private String Location;
        private String Thema;
        private String Title;
        private long FavoriteCnt;

        public WellnessResponse(Wellness wellness) {
            this.WellnessId = wellness.getId();
            this.Location = wellness.getLocation();
            this.Thema = wellness.getThema();
            this.Title = wellness.getTitle();
            this.FavoriteCnt = wellness.getFavoriteCount();
        }
    }

    @Data
    public static class WellnessRequest {
        private long WellnessId;
        private String Location;
        private String Thema;
        private String Title;
        private long FavoriteCnt;
    }
}
