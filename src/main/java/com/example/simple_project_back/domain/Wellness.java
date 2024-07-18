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
    private long Id;
    private String Location;
    private String Thema;
    private String Title;

    public Wellness(String location, String thema, String title) {
        this.Location = location;
        this.Thema = thema;
        this.Title = title;
    }


    @Column(name = "favorite_count")
    private Long FavoriteCount = 0L;

}
