package com.example.simple_project_back.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
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

    private Long isOwner;

    public Member(String userID, String password, String nickName, String eMail) {
        this.userId = userID;
        this.setPassword(password);
        this.nickName = nickName;
        this.eMail = eMail;
        this.isOwner = 0L;
    }


    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public void setPassword(String password){
        this.password = passwordEncoder.encode(password);
    }


    public boolean checkPassword(String password){
        return passwordEncoder.matches(password, this.password);
    }


    public Long getIsOwner(){
        return this.isOwner;
    }
}
