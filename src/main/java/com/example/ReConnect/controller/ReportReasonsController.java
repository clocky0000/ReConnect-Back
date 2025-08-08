package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ReportReasonsDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.service.DiaryService;
import com.example.ReConnect.service.ReportReasonsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/report/reasons")
public class ReportReasonsController {

    private final ReportReasonsService reportReasonsService;
    private final DiaryService diaryService;

    public ReportReasonsController(ReportReasonsService reportReasonsService, DiaryService diaryService) {
        this.reportReasonsService = reportReasonsService;
        this.diaryService = diaryService;
    }

    @GetMapping("/{userId}/{date}")
    public ResponseEntity<ReportReasonsDto> getReportReasons(@PathVariable String userId,
                                                             @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        Diary diary = diaryService.getDiaryEntity(userId, date);
        ReportReasonsDto reportReasonsDto = reportReasonsService.getReportReasons(diary);

        return ResponseEntity.ok(reportReasonsDto);
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveReportReasons(@RequestBody ReportReasonsDto dto, HttpSession session) throws JsonProcessingException {
        String userId = (String) session.getAttribute("loginId");
        if(userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        LocalDate date = dto.getDate();
        Diary diary = diaryService.getDiaryEntity(userId, date);

        reportReasonsService.saveReportReasons(dto, diary);
        return ResponseEntity.ok().body("이유 저장 완료");
    }
}
