package com.example.ReConnect.service;

import com.example.ReConnect.dto.FinalReportDto;
import com.example.ReConnect.entity.FinalReport;
import com.example.ReConnect.repository.FinalReportRepository;
import org.springframework.stereotype.Service;

@Service
public class FinalReportService {

    private final FinalReportRepository finalReportRepository;

    public FinalReportService(FinalReportRepository finalReportRepository) {
        this.finalReportRepository = finalReportRepository;
    }

    public void saveFinalReport(FinalReportDto dto, String coupleCode) {
        FinalReport finalReport = new FinalReport();

        finalReport.setCoupleCode(coupleCode);
        finalReport.setMeta(dto.getMeta());
        finalReport.setHeader(dto.getHeader());
        finalReport.setFinalProfiles(dto.getFinalProfiles());
        finalReport.setDeltaVsBaseline(dto.getDeltaVsBaseline());
        finalReport.setPlot(dto.getPlot());
        finalReport.setSummary(dto.getSummary());
        finalReport.setFinalInterpretation(dto.getFinalInterpretation());
        finalReport.setFinalStrengths(dto.getFinalStrengths());
        finalReport.setFinalIssues(dto.getFinalIssues());
        finalReport.setRecommendations(dto.getRecommendations());
        finalReport.setTimeSeriesSummary(dto.getTimeSeriesSummary());

        finalReportRepository.save(finalReport);
    }

    public FinalReportDto getFinalReport(String coupleCode) {
        FinalReport finalReport = finalReportRepository.findByCoupleCode(coupleCode)
                .orElseThrow(() -> new RuntimeException("파이널 리포트 없음"));

        return new FinalReportDto(
                finalReport.getSummary(),
                finalReport.getMeta(),
                finalReport.getHeader(),
                finalReport.getDeltaVsBaseline(),
                finalReport.getPlot(),
                finalReport.getSummary(),
                finalReport.getFinalInterpretation(),
                finalReport.getFinalStrengths(),
                finalReport.getFinalIssues(),
                finalReport.getRecommendations(),
                finalReport.getTimeSeriesSummary()
        );
    }
}
