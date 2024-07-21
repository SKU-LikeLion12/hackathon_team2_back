package com.example.simple_project_back.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wellnessId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wellness wellness;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int headCnt;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime checkIn;
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime inTime;

    private int isBook;

    public Book(Member member, Wellness wellness, String content ,int headCnt, LocalDateTime checkIn, LocalDateTime inTime) {
        this.member = member;
        this.wellness = wellness;
        this.content = content;
        this.headCnt = headCnt;
        this.checkIn = checkIn;
        this.inTime = inTime;
        isBook = 0;
    }

}
