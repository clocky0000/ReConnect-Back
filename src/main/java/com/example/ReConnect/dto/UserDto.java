package com.example.ReConnect.dto;

import com.example.ReConnect.entity.User;
import java.time.LocalDate;

public class UserDto {
    private String userId;
    private String password;
    private String passwordConfirm;     // 비밀번호 확인용 -> entity 저장 X
    private String name;
    private LocalDate birthDate;    // 생년월일 (yyyy-MM-dd -> LocalDate 변환)
    private String job;
    private Boolean isSubscribed;

    public UserDto() {}

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

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
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

    public Boolean getIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(Boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setUserId(user.getUserId());
        dto.setPassword(user.getPassword());
        dto.setName(user.getName());
        dto.setBirthDate(user.getBirthDate());
        dto.setJob(user.getJob());
        dto.setIsSubscribed(user.isSubscribed());
        return dto;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", job='" + job + '\'' +
                ", isSubscribed=" + isSubscribed +
                '}';
    }
}