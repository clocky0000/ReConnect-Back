package com.example.ReConnect.controller;

import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    // 생성자
    private final UserService userService;

    // 회원가입 처리
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        try {
            // 1. 비밀번호 확인
            if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
                return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다.");
            }

            // 2. 아이디 중복 검사
            if (userService.isIdExists(userDto.getUserId())) {
                return ResponseEntity.badRequest().body("이미 사용 중인 아이디입니다.");
            }

            // 3. 구독 기본값 설정
            if (userDto.getIsSubscribed() == null) {
                userDto.setIsSubscribed(false);
            }
            
            userService.save(userDto);
            return ResponseEntity.ok("회원가입 성공");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("회원가입 중 오류 발생");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody UserDto userDto, HttpSession session) {
        UserDto loginResult = userService.login(userDto);
        if (loginResult != null) {
            session.setAttribute("loginId", loginResult.getUserId());
            return ResponseEntity.ok(loginResult);
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        try {
            UserDto user = userService.findById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("사용자 조회 오류");
        }
    }
}
