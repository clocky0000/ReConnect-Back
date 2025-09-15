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
        finalReport.setSummary(dto.getSummary());
        finalReport.setTimeSeries(dto.getTimeSeries());
        finalReport.setProfiles(dto.getProfiles());
        finalReport.setFinalCombination(dto.getFinalCombination());
        finalReport.setRecommendations(dto.getRecommendations());
        finalReport.setAudit(dto.getAudit());
        finalReport.setAppendix(dto.getAppendix());
        finalReport.setLineage(dto.getLineage());

        finalReportRepository.save(finalReport);
    }

    public FinalReportDto getFinalReport(String coupleCode) {
        FinalReport finalReport = finalReportRepository.findByCoupleCode(coupleCode)
                .orElseThrow(() -> new RuntimeException("파이널 리포트 없음"));

        return new FinalReportDto(
                finalReport.getSummary(),
                finalReport.getTimeSeries(),
                finalReport.getProfiles(),
                finalReport.getFinalCombination(),
                finalReport.getRecommendations(),
                finalReport.getAudit(),
                finalReport.getAppendix(),
                finalReport.getLineage()
        );
    }
}
