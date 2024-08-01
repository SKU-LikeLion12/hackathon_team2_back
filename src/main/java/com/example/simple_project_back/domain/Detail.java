package com.example.simple_project_back.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Detail {

    @Id
    private Long pkId;

    @Column(columnDefinition = "TEXT")
    private String introduce;

    private String hp;
    private String address;
    private String url;
    private String workTime;
    private String title;

    private double lati;
    private double hard;

    @OneToOne(fetch = FetchType.LAZY )
    @MapsId
    @JoinColumn(name = "id")
    private Wellness wellness;

    public Detail(String introduce, String hp, String address,
                  String url, String workTime, String title,
                  double lati, double hard, Wellness wellness){

        this.introduce = introduce;
        this.hp = hp;
        this.address = address;
        this.url = url;
        this.workTime = workTime;
        this.title = title;
        this.lati = lati;
        this.hard = hard;
        this.wellness = wellness;
    }

}
