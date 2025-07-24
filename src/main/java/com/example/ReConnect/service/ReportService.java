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
                report.getAttachmentTheory(),
                report.getDefenseMechanism(),
                report.getThinkingPattern(),
                report.getStrengthTheory(),
                report.getSelfDetermination(),
                report.getSecureBase()
        );
    }



    public void saveReport(ReportRequestDto dto, String userId) throws JsonProcessingException {
        Report report = new Report();

        report.setUserId(userId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedDate = LocalDate.parse(dto.getDate(), formatter);
        report.setDate(parsedDate);

        report.setInputText(dto.getInputText());
        report.setAttachmentTheory(dto.getAttachmentTheory());
        report.setDefenseMechanism(dto.getDefenseMechanism());
        report.setThinkingPattern(dto.getThinkingMechanism());
        report.setStrengthTheory(dto.getStrengthTheory());
        report.setSelfDetermination(dto.getSelfDetermination());
        report.setSecureBase(dto.getSecureBase());

        reportRepository.save(report);
    }
}
