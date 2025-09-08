package com.example.ReConnect.entity;

import com.example.ReConnect.dto.UserDto;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", columnDefinition = "TEXT")
    private String userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "birth_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDate birthDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String job;

    @Column(name="couple_code", columnDefinition = "TEXT", unique = true)
    private String coupleCode;

    @Column(name="partner_id", columnDefinition = "TEXT")
    private String partnerId;

    @Column(name = "is_subscribed", nullable = false)
    private boolean isSubscribed = false;

    public User() {}

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getJob() {
        return job;
    }
    public void setJob(String job) {
        this.job = job;
    }

    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

    public String getPartnerId() { return partnerId; }
    public void setPartnerId(String partnerId) { this.partnerId = partnerId; }

    public boolean isSubscribed() {
        return isSubscribed;
    }
    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public static User toUser(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setJob(dto.getJob());
        user.setCoupleCode(dto.getCoupleCode());
        user.setPartnerId(dto.getPartnerId());
        user.setSubscribed(dto.getIsSubscribed() != null && dto.getIsSubscribed());
        return user;
    }
}
