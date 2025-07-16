package com.example.ReConnect.dto;

import com.example.ReConnect.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String password;
    private String passwordConfirm;     // 비밀번호 확인용 -> entity 저장 X
    private String name;
    private LocalDate birthDate;    // 생년월일 (yyyy-MM-dd -> LocalDate 변환)
    private String job;
    private Boolean isSubscribed;

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
}
