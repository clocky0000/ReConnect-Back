package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ReportTextDto;
import com.example.ReConnect.service.ReportTextService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api/report/text")
public class ReportTextController {

    private final ReportTextService reportTextService;
    public ReportTextController(ReportTextService reportTextService) {
        this.reportTextService = reportTextService;
    }

//    @GetMapping("/{userId}/{date}")
//    public ResponseEntity<ReportTextDto> getReportText(@PathVariable String userId,
//                                                       @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        ReportTextDto reportTextDto = reportTextService.getReportText(userId, date);
//        return ResponseEntity.ok(reportTextDto);
//    }
//
//    @PostMapping("/save")
//    public ResponseEntity<?> saveReportText(@RequestBody ReportTextDto dto, HttpSession session) throws JsonProcessingException {
//        String userId = (String) session.getAttribute("loginId");
//        if (userId == null) {
//            return ResponseEntity.status(401).body("로그인이 필요합니다.");
//        }
//        reportTextService.saveReportText(dto, userId);
//        return ResponseEntity.ok("줄글 텍스트 저장 완료");
//    }
}
