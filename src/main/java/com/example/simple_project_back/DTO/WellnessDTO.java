package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Wellness;
import lombok.Data;

public class WellnessDTO {

    @Data
    public static class WellnessResponse{
        private Long wellness_id;
        private String title;
        private int location;
        private int theme;


        public WellnessResponse(Wellness wellness){
            this.wellness_id = wellness.getId();
            this.title = wellness.getTitle();
            this.location = wellness.getLocation();
            this.theme = wellness.getTheme();
        }

    }

    @Data
    public static class WellnessRequest{
        private int location;
        private int theme;
        private String title;
    }

}
