package com.example.ReConnect.controller;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.service.DiaryService;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/diary")           /*postman같은거 테스트할때 요런 부분 유의해서 url 쓰면된다요*/
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitDiary(@RequestBody DiaryRequestDto dto, HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        diaryService.submitDiary(dto, userId);
        return ResponseEntity.ok("제출 완료");
    }

    @GetMapping("/{userId}/{date}")
    public ResponseEntity<DiaryRequestDto> getDiary(@PathVariable String userId,
                                      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        DiaryRequestDto dto = diaryService.getDiary(userId, date);
        return ResponseEntity.ok(diaryService.getDiary(userId, date));
    }

}
