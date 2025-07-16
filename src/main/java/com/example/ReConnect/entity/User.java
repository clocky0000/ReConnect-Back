package com.example.ReConnect.entity;

import com.example.ReConnect.dto.UserDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "users")      // database에 해당 이름의 테이블 생성
public class User {

    @Id
    @Column(name = "user_id", columnDefinition = "TEXT")
    private String userId;      // Primary Key

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "birth_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate birthDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String job;

    @Column(name = "is_subscribed", nullable = false)
    private boolean isSubscribed = false;

    public static User toUser(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setJob(dto.getJob());

        return user;
    }

}
