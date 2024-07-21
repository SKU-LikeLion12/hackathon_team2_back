package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Wellness;
import lombok.Data;

public class WellnessDTO {

    @Data
    public static class ResponseWellness{
        private Long wellness_id;
        private String title;
        private int location;
        private int theme;


        public ResponseWellness(Wellness wellness){
            this.wellness_id = wellness.getId();
            this.title = wellness.getTitle();
            this.location = wellness.getLocation();
            this.theme = wellness.getTheme();
        }

    }







}
