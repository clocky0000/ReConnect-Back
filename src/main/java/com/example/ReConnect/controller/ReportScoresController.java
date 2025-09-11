package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ReportScoresDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.service.DiaryService;
import com.example.ReConnect.service.ReportScoresService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/report/scores")
public class ReportScoresController {

    private final ReportScoresService reportScoresService;
    private final DiaryService diaryService;

    public ReportScoresController(ReportScoresService reportScoresService, DiaryService diaryService) {
        this.reportScoresService = reportScoresService;
        this.diaryService = diaryService;
    }

//    @GetMapping("/{userId}/{date}")
//    public ResponseEntity<ReportScoresDto> getReportScores(@PathVariable String userId,
//                                                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        Diary diary = diaryService.getDiaryEntity(userId, date);
//        ReportScoresDto reportScoresDto = reportScoresService.getReportScores(diary);
//
//        return ResponseEntity.ok(reportScoresDto);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> saveReportScores(@RequestBody ReportScoresDto dto, HttpSession session) throws JsonProcessingException {
//        String userId = (String) session.getAttribute("loginId");
//        if (userId == null) {
//            return ResponseEntity.status(401).body("로그인이 필요합니다.");
//        }
//
//        LocalDate date = dto.getDate();
//        Diary diary = diaryService.getDiaryEntity(userId, date);
//
//        reportScoresService.saveReportScores(dto, diary);
//        return ResponseEntity.ok().body("점수 저장 완료");
//    }
}
