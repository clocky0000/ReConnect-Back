package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ReportRequestDto;
import com.example.ReConnect.entity.Report;
import com.example.ReConnect.service.ReportService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/{userId}/{date}")     /*이게 postman으로 api 테스트 할때 사용하는 용도 - db에 있는 보고서 가져오기*/
    public ResponseEntity<String> getReport(@PathVariable String userId,
                                            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        String json = reportService.getReport(userId, date);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/get")         /*위에랑 같은 거긴 한데 html에서 테스트 할때 보려고 사용한 용도임 - db에 있는 보고서 가져오기*/
    public ResponseEntity<String> getReportQuery(@RequestParam String userId,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        String json = reportService.getReport(userId, date);
        return ResponseEntity.ok(json);
    }


    @PostMapping("/save")               /*이건 그냥 보고서 저장인디 JSON 형태 저장하는거 테스트한거임*/
    public ResponseEntity<?> saveReport(@RequestBody ReportRequestDto dto) throws JsonProcessingException {
        reportService.saveReport(dto);
        return ResponseEntity.ok("분석 저장 완료");
    }
}
