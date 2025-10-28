package com.example.ReConnect.controller;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.service.DiaryService;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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

    // 세션 없이 파트너 일기 불러오기
    @GetMapping("/partner/{userId}/{coupleCode}/{questionNumber}")
    public ResponseEntity<?> getPartnerDiary(@PathVariable String userId,
                                             @PathVariable String coupleCode, @PathVariable Integer questionNumber) {
        // userId로 partnerId 조회
        String partnerId = userService.findById(userId).getPartnerId();
        if (partnerId == null) {
            return ResponseEntity.badRequest().body("연인을 먼저 지정해주세요");
        }

        DiaryRequestDto partnerDiary = diaryService.getPartnerDiary(partnerId, coupleCode, questionNumber);
        if (partnerDiary == null) {
            return ResponseEntity.badRequest().body("상대방이 일기를 작성하지 않았습니다.");
        }

        return ResponseEntity.ok(partnerDiary);
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

    @GetMapping("/last-completed-check/{coupleCode}")  //확인하고 보내는거
    public ResponseEntity<?> getLastCompletedAndMaybeNotify(
            @PathVariable String coupleCode,
            @RequestParam(required = false) String userId, // 없으면 세션에서
            HttpSession session
    ) {
        if (userId == null || userId.isBlank()) {
            Object loginId = session.getAttribute("loginId");
            if (loginId != null) userId = String.valueOf(loginId);
        }

        int last = diaryService.getLastCompletedQuestion(coupleCode);
        boolean notified = false;
        try {
            notified = diaryService.notifyCompleteIf36(userId, coupleCode);
        } catch (Exception e) {
            System.err.println("[DiaryController] notifyCompleteIf36 error: " + e.getMessage());
        }

        return ResponseEntity.ok(Map.of(
                "lastCompleted", last,
                "notified", notified
        ));
    }

    // 다음 질문 번호 (최대 36)
    @GetMapping("/next/{coupleCode}")
    public int getNextQuestion(@PathVariable String coupleCode) {
        return diaryService.getNextQuestionNumber(coupleCode);
    }

    @GetMapping("/test-send")   // 수동으로 확인
    public ResponseEntity<String> testSend(
            @RequestParam String userId,
            @RequestParam String coupleCode
    ) {
        boolean ok = diaryService.notifyCompleteIf36(userId, coupleCode);
        return ResponseEntity.ok(ok ? "전송 성공" : "전송 실패");
    }

}
