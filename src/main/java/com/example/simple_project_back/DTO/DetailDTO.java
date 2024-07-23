package com.example.simple_project_back.DTO;

import com.example.simple_project_back.domain.Detail;
import lombok.Data;

public class DetailDTO {

    @Data
    public static class DetailRequest {
        private String introduce;
        private String hp;
        private String address;
        private String url;
        private String workTime;
        private String title;
        private double lati;
        private double hard;


        public DetailRequest(WellnessDTO.WellnessRequest request){
            this.introduce = request.getIntroduce();
            this.hp = request.getHp();
            this.address = request.getAddress();
            this.url = request.getUrl();
            this.workTime = request.getWorkTime();
            this.title = request.getTitle();
            this.lati = request.getLati();
            this.hard = request.getHard();
        }
    }


    @Data
    public static class DetailResponse {
        private String introduce;
        private String hp;
        private String address;
        private String url;
        private String workTime;
        private String title;
        private double lati;
        private double hard;


        public DetailResponse(Detail detail) {
            this.introduce = detail.getIntroduce();
            this.hp = detail.getHp();
            this.address = detail.getAddress();
            this.url = detail.getUrl();
            this.workTime = detail.getWorkTime();
            this.title = detail.getTitle();
            this.lati = detail.getLati();
            this.hard = detail.getHard();
        }
    }

    @Data
    public static class DetailGetRequest{
        private Long wellnessId;
    }

}
