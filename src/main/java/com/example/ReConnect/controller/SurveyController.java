package com.example.ReConnect.controller;

import com.example.ReConnect.dto.SurveyDto;
import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.service.SurveyService;
import com.example.ReConnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/survey")
public class SurveyController {

    private final SurveyService surveyService;
    private final UserService userService;

    @Autowired
    public SurveyController(SurveyService surveyService, UserService userService) {
        this.surveyService = surveyService;
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody SurveyDto dto, HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");
        }
        UserDto me = userService.findById(userId);
        if (me == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 유저입니다.");
        }
        dto.setUserId(userId);
        dto.setCoupleCode(me.getCoupleCode());

        surveyService.save(dto);
        return ResponseEntity.ok("saved");
    }

    @GetMapping("/{userId}/{coupleCode}")
    public ResponseEntity<?> getByPath(@PathVariable String userId, @PathVariable String coupleCode) {
        SurveyDto dto = surveyService.getByUserIdAndCoupleCode(userId, coupleCode);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/me")
    public ResponseEntity<?> getMySurvey(HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인이 필요합니다.");

        var me = userService.findById(userId);     // UserDto 반환 (coupleCode 포함)
        if (me == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("존재하지 않는 유저입니다.");

        var dto = surveyService.getByUserIdAndCoupleCode(userId, me.getCoupleCode());
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }
}
