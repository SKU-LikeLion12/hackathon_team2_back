package com.example.simple_project_back.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Entity
@NoArgsConstructor
public class Wellness {
    @Id @GeneratedValue
    private long id;

    private int location;
    private int theme;
    private String title;
    private long favoriteCnt;
    private double hard;
    private double rati;

    public Wellness(int location, int theme, String title, double rati, double hard) {
        this.location = location;
        this.theme = theme;
        this.title = title;
        this.favoriteCnt = 0;
        this.rati = rati;
        this.hard = hard;

    }


}
