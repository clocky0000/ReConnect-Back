package com.example.ReConnect.controller;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.service.DiaryService;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/diary")           /*postman같은거 테스트할때 요런 부분 유의해서 url 쓰면된다요*/
public class DiaryController {

    private final DiaryService diaryService;
    private final UserService userService;

    public DiaryController(DiaryService diaryService, UserService userService) {
        this.diaryService = diaryService;
        this.userService = userService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitDiary(@RequestBody DiaryRequestDto dto, HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        String coupleCode = userService.findById(userId).getCoupleCode();
        Integer questionNumber = dto.getQuestionNumber();

        try {
            diaryService.submitDiary(dto, userId, coupleCode, questionNumber);
            return ResponseEntity.ok("제출 완료");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("서버 에러");
        }
    }

    @GetMapping("/{userId}/{coupleCode}/{questionNumber}")
    public ResponseEntity<?> getDiary(@PathVariable String userId,
                                                    @PathVariable String coupleCode, @PathVariable Integer questionNumber) {
        DiaryRequestDto myDiary = diaryService.getDiary(userId, coupleCode, questionNumber);
        if (myDiary == null) {
            return ResponseEntity.badRequest().body("나의 일기를 작성해주세요.");
        }

        return ResponseEntity.ok(myDiary);
    }

    @GetMapping("/partner/{questionNumber}")
    public ResponseEntity<?> getDiaryPartner(@PathVariable Integer questionNumber, HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        String coupleCode = userService.findById(userId).getCoupleCode();
        String partnerId = userService.findById(userId).getPartnerId();

        DiaryRequestDto myDiary = diaryService.getDiary(userId, coupleCode, questionNumber);
        if (myDiary == null) {
            return ResponseEntity.badRequest().body("나의 일기를 작성해주세요.");
        }

        DiaryRequestDto partnerDiary = diaryService.getPartnerDiary(partnerId, coupleCode, questionNumber);
        if (partnerDiary == null) {
            return ResponseEntity.badRequest().body("아직 일기를 작성하지 않았습니다.");
        }

        return ResponseEntity.ok(partnerDiary);
    }

    //마지막 질문 번호
    @GetMapping("/last-completed/{coupleCode}")
    public int getLastCompleted(@PathVariable String coupleCode) {
        return diaryService.getLastCompletedQuestion(coupleCode);
    }

    // 다음 질문 번호 (최대 36)
    @GetMapping("/next/{coupleCode}")
    public int getNextQuestion(@PathVariable String coupleCode) {
        return diaryService.getNextQuestionNumber(coupleCode);
    }
}
