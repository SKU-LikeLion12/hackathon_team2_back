package com.example.simple_project_back.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor
@Getter
@Entity
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userId;

    private String password;
    @Setter
    private String nickName;
    @Setter
    private String eMail;

    private int isOwner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "managerId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Wellness wellness;


    // ?
    public Member(String userID, String password, String nickName, String eMail) {
        this.userId = userID;
        this.setPassword(password);
        this.nickName = nickName;
        this.eMail = eMail;
        this.isOwner = 0;
        this.wellness = null;
    }


    // 회원가입 시 테이블에 들어갈 정보들의 틀
    public Member(String userID, String password, String nickName, String eMail, int isOwner, Wellness wellness) {
        this.userId = userID;
        this.setPassword(password);
        this.nickName = nickName;
        this.eMail = eMail;
        this.isOwner = isOwner;
        this.wellness = wellness;
    }


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void setPassword(String password){
        this.password = passwordEncoder.encode(password);
    }


    public boolean checkPassword(String password){
        return passwordEncoder.matches(password, this.password);
    }


    public int getIsOwner(){
        return this.isOwner;
    }
}