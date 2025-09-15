package com.example.ReConnect.service;

import com.example.ReConnect.dto.ItemReportDto;
import com.example.ReConnect.entity.ItemReport;
import com.example.ReConnect.repository.ItemReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemReportService {

    private final ItemReportRepository itemReportRepository;

    public ItemReportService(ItemReportRepository itemReportRepository) {
        this.itemReportRepository = itemReportRepository;
    }

    public ItemReportDto saveItemReport(ItemReportDto dto, String coupleCode, Integer itemId, String idempotencyKey) {
        // 기존 리포트 조회
        ItemReport existingReport = itemReportRepository.findByIdempotencyKey(idempotencyKey)
                .orElse(null);

        if (existingReport != null) {
            return new ItemReportDto(
                    existingReport.getMeta(),
                    existingReport.getQuestion(),
                    existingReport.getPartners(),
                    existingReport.getCoupleProfile(),
                    existingReport.getCharts(),
                    existingReport.getStrengths(),
                    existingReport.getIssues(),
                    existingReport.getAdvice(),
                    existingReport.getAudit()
            );
        }

        ItemReport itemReport = new ItemReport();
        itemReport.setCoupleCode(coupleCode);
        itemReport.setItemId(itemId);
        itemReport.setIdempotencyKey(idempotencyKey);
        itemReport.setMeta(dto.getMeta());
        itemReport.setQuestion(dto.getQuestion());
        itemReport.setPartners(dto.getPartners());
        itemReport.setCoupleProfile(dto.getCoupleProfile());
        itemReport.setCharts(dto.getCharts());
        itemReport.setStrengths(dto.getStrengths());
        itemReport.setIssues(dto.getIssues());
        itemReport.setAdvice(dto.getAdvice());
        itemReport.setAudit(dto.getAudit());

        itemReportRepository.save(itemReport);

        return new ItemReportDto(
                itemReport.getMeta(),
                itemReport.getQuestion(),
                itemReport.getPartners(),
                itemReport.getCoupleProfile(),
                itemReport.getCharts(),
                itemReport.getStrengths(),
                itemReport.getIssues(),
                itemReport.getAdvice(),
                itemReport.getAudit()
        );
    }

    public ItemReportDto getItemReport(String coupleCode, Integer itemId) {
        ItemReport itemReport = itemReportRepository.findByCoupleCodeAndItemId(coupleCode, itemId)
                .orElseThrow(() -> new RuntimeException("아이템 리포트 없음"));

        return new ItemReportDto(
                itemReport.getMeta(),
                itemReport.getQuestion(),
                itemReport.getPartners(),
                itemReport.getCoupleProfile(),
                itemReport.getCharts(),
                itemReport.getStrengths(),
                itemReport.getIssues(),
                itemReport.getAdvice(),
                itemReport.getAudit()
        );
    }
}
