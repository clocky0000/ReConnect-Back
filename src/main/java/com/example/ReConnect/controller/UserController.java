package com.example.ReConnect.controller;

import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDto userDto) {
        try {
            if (!userDto.getPassword().equals(userDto.getPasswordConfirm())) {
                return ResponseEntity.badRequest().body("비밀번호가 일치하지 않습니다.");
            }

            if (userService.isIdExists(userDto.getUserId())) {
                return ResponseEntity.badRequest().body("이미 사용 중인 아이디입니다.");
            }

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
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(jakarta.servlet.http.HttpSession session) {
        session.invalidate(); // 세션을 삭제해옹
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        try {
            UserDto user = userService.findById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("사용자 조회 오류");
        }
    }

    // 연인 코드 발급
    @PostMapping("/{userId}/coupleCode")
    public ResponseEntity<UserDto> generateCoupleCode(@PathVariable String userId) {
        try {
            UserDto dto = userService.assignCoupleCode(userId);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // 연인 코드 연결
    @PostMapping("/{userId}/connect")
    public ResponseEntity<UserDto> connectWithCoupleCode(
            @PathVariable String userId,
            @RequestParam String coupleCode) {
        if (coupleCode == null || coupleCode.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            UserDto dto = userService.connectWithCoupleCode(userId, coupleCode);
            return ResponseEntity.ok(dto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

