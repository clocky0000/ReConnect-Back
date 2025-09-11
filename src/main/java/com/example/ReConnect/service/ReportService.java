package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportRequestDto;
import com.example.ReConnect.dto.ReportResponseDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.Report;
import com.example.ReConnect.repository.DiaryRepository;
import com.example.ReConnect.repository.ReportRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ReportService {

    private final ReportRepository reportRepository;
    private final DiaryRepository diaryRepository;

    public ReportService(ReportRepository reportRepository, DiaryRepository diaryRepository) {
        this.reportRepository = reportRepository;
        this.diaryRepository = diaryRepository;
    }

//    public ReportResponseDto getReport(String userId, LocalDate date) {
//        Diary diary = diaryRepository.findByUserIdAndDate(userId, date)
//                .orElseThrow(() -> new RuntimeException("일기 없음"));
//
//        Report report = reportRepository.findByDiary(diary)
//                .orElseThrow(() -> new RuntimeException("보고서 없음"));
//        return new ReportResponseDto(
//                report.getReportTitle(),
//                report.getKeyEmotions(),
//                report.getCoreKeywords(),
//                report.getIndicatorTrends(),
//                report.getCurrentAnalysis(),
//                report.getSolution(),
//                report.getFeedbackAndCheer(),
//                report.getRepetitivePattern(),
//                report.getRecommendation()
//        );
//    }
//
//    public void saveReport(ReportRequestDto dto, String userId) throws JsonProcessingException {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate parsedDate = LocalDate.parse(dto.getDate(), formatter);
//
//        Diary diary = diaryRepository.findByUserIdAndDate(userId, parsedDate)
//                .orElseThrow(() -> new RuntimeException("일기 없음"));
//
//        Report report = new Report();
//        report.setUserId(userId);
//        report.setDate(parsedDate);
//        report.setInputText(dto.getInputText());
//        report.setReportTitle(dto.getReportTitle());
//        report.setKeyEmotions(dto.getKeyEmotions());
//        report.setCoreKeywords(dto.getCoreKeywords());
//        report.setIndicatorTrends(dto.getIndicatorTrends());
//        report.setCurrentAnalysis(dto.getCurrentAnalysis());
//        report.setSolution(dto.getSolution());
//        report.setFeedbackAndCheer(dto.getFeedbackAndCheer());
//        report.setRepetitivePattern(dto.getRepetitivePattern());
//        report.setRecommendation(dto.getRecommendation());
//        report.setDiary(diary);
//        reportRepository.save(report);
//    }
}
