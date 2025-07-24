package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ReportRequestDto;
import com.example.ReConnect.dto.ReportResponseDto;
import com.example.ReConnect.dto.ReportTextDto;
import com.example.ReConnect.entity.Report;
import com.example.ReConnect.service.ReportService;
import com.example.ReConnect.service.ReportTextService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;
    private final ReportTextService reportTextService;

    public ReportController(ReportService reportService, ReportTextService reportTextService) {
        this.reportService = reportService;
        this.reportTextService = reportTextService;
    }

    @GetMapping("/{userId}/{date}")     /*이게 postman으로 api 테스트 할때 사용하는 용도 - db에 있는 보고서 가져오기*/
    public ResponseEntity<ReportResponseDto> getReport(@PathVariable String userId,
                                            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        ReportResponseDto reportDto = reportService.getReport(userId, date);
        return ResponseEntity.ok(reportDto);
    }

    @GetMapping("/get")         /*위에랑 같은 거긴 한데 html에서 테스트 할때 보려고 사용한 용도임 - db에 있는 보고서 가져오기*/
    public ResponseEntity<ReportResponseDto> getReportQuery(@RequestParam String userId,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        ReportResponseDto reportDto = reportService.getReport(userId, date);
        return ResponseEntity.ok(reportDto);
    }

    @GetMapping("/text/{userId}/{date}")
    public ResponseEntity<ReportTextDto> getReportText(@PathVariable String userId,
                                                           @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        ReportTextDto reportTextDto = reportTextService.getReportText(userId, date);
        return ResponseEntity.ok(reportTextDto);
    }

    @PostMapping("/save")               /*이건 그냥 보고서 저장인디 JSON 형태 저장하는거 테스트한거임*/
    public ResponseEntity<?> saveReport(@RequestBody ReportRequestDto dto, HttpSession session) throws JsonProcessingException {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }
        reportService.saveReport(dto, userId);
        return ResponseEntity.ok("분석 저장 완료");
    }

    @PostMapping("/text/save")
    public ResponseEntity<?> saveReportText(@RequestBody ReportTextDto dto, HttpSession session) throws JsonProcessingException {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }
        reportTextService.saveReportText(dto, userId);
        return ResponseEntity.ok("줄글 텍스트 저장 완료");
    }
}
