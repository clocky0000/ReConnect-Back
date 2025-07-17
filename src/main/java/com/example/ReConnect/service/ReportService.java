package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportRequestDto;
import com.example.ReConnect.entity.Report;
import com.example.ReConnect.repository.ReportRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public String getReport(String userId, LocalDate date) {
        Report report = reportRepository.findByUserIdAndDate(userId, date)
                .orElseThrow(() -> new RuntimeException("보고서 없음"));
        return report.getAnalysisJson().toString();
    }

    public void saveReport(ReportRequestDto dto, String userId) throws JsonProcessingException {
        Report report = new Report();

        report.setUserId(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(dto.getDate(), formatter);
        report.setDate(parsedDate);

        report.setAnalysisJson(dto.getAnalysisJson());

        reportRepository.save(report);

    }
}
