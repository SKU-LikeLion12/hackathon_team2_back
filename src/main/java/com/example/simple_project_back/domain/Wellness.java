package com.example.simple_project_back.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// 위도,경도(double)
@NoArgsConstructor
@Getter
@Entity
public class Wellness {
    @Id@GeneratedValue
    private long id;
    private String location;
    private String thema;
    private String title;
    private double lati;
    private double hard;

    public Wellness(String location, String thema, String title) {
        this.location = location;
        this.thema = thema;
        this.title = title;
        this.lati = getLati();
        this.hard = getHard();
    }
    public void update(String thema, String title) {
        this.thema = thema;
        this.title = title;
    }
    @Setter
    @Column(name = "favorite_count")
    private Long favoriteCount = 0L;

}
