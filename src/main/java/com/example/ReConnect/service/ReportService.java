package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportRequestDto;
import com.example.ReConnect.dto.ReportResponseDto;
import com.example.ReConnect.entity.Report;
import com.example.ReConnect.repository.ReportRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public ReportResponseDto getReport(String userId, LocalDate date) {
        Report report = reportRepository.findByUserIdAndDate(userId, date)
                .orElseThrow(() -> new RuntimeException("보고서 없음"));
        return new ReportResponseDto(
                report.getReportTitle(),
                report.getKeyEmotions(),
                report.getCoreKeywords(),
                report.getIndicatorTrends(),
                report.getCurrentAnalysis(),
                report.getSolution(),
                report.getFeedbackAndCheer(),
                report.getRepetitivePattern(),
                report.getRecommendation()
        );
    }

    public void saveReport(ReportRequestDto dto, String userId) throws JsonProcessingException {
        Report report = new Report();

        report.setUserId(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(dto.getDate(), formatter);
        report.setDate(parsedDate);

        report.setInputText(dto.getInputText());
        report.setReportTitle(dto.getReportTitle());
        report.setKeyEmotions(dto.getKeyEmotions());
        report.setCoreKeywords(dto.getCoreKeywords());
        report.setIndicatorTrends(dto.getIndicatorTrends());
        report.setCurrentAnalysis(dto.getCurrentAnalysis());
        report.setSolution(dto.getSolution());
        report.setFeedbackAndCheer(dto.getFeedbackAndCheer());
        report.setRepetitivePattern(dto.getRepetitivePattern());
        report.setRecommendation(dto.getRecommendation());

        reportRepository.save(report);
    }
}
