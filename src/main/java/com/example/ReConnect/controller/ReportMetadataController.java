package com.example.ReConnect.controller;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.dto.ReportMetadataDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportMetadata;
import com.example.ReConnect.service.DiaryService;
import com.example.ReConnect.service.ReportMetadataService;
import com.example.ReConnect.service.ReportReasonsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/report/metadata")
public class ReportMetadataController {

    private final ReportMetadataService reportMetadataService;
    private final DiaryService diaryService;

    public ReportMetadataController(ReportMetadataService reportMetadataService, DiaryService diaryService) {
        this.reportMetadataService = reportMetadataService;
        this.diaryService = diaryService;
    }
//
//    @GetMapping("/{userId}/{date}")
//    public ResponseEntity<ReportMetadataDto> getReportMetadata(@PathVariable String userId,
//                                                            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate date) {
//        Diary diary = diaryService.getDiaryEntity(userId, date);
//        ReportMetadataDto reportMetadataDto = reportMetadataService.getReportMeta(diary);
//
//        return ResponseEntity.ok(reportMetadataDto);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> saveReportMetadata(@RequestBody ReportMetadataDto dto, HttpSession session) throws JsonProcessingException {
//        String userId = (String) session.getAttribute("loginId");
//        if (userId == null) {
//            return ResponseEntity.status(401).body("로그인이 필요합니다.");
//        }
//
//        LocalDate date = dto.getDate();
//        Diary diary = diaryService.getDiaryEntity(userId, date);
//
//        reportMetadataService.saveReportMetadata(dto, diary);
//        return ResponseEntity.ok().body("메타 저장 완료");
//    }
}
