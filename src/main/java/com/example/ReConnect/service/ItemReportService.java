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

    //
    public int getLastReportItemId(String coupleCode) {
        return itemReportRepository.findLastReportItemId(coupleCode);
    }

    public ItemReportDto saveItemReport(ItemReportDto dto, String coupleCode, Integer itemId) {
        // 기존 리포트 조회
        ItemReport existingReport = itemReportRepository.findByCoupleCodeAndItemId(coupleCode, itemId)
                .orElse(null);

        if (existingReport != null) {
            return new ItemReportDto(
                    existingReport.getMeta(),
                    existingReport.getHeader(),
                    existingReport.getLabelsNow(),
                    existingReport.getMetrics(),
                    existingReport.getPlot(),
                    existingReport.getPartners(),
                    existingReport.getInterpretation()
            );
        }

        ItemReport itemReport = new ItemReport();
        itemReport.setCoupleCode(coupleCode);
        itemReport.setItemId(itemId);
        itemReport.setMeta(dto.getMeta());
        itemReport.setHeader(dto.getHeader());
        itemReport.setLabelsNow(dto.getLabelsNow());
        itemReport.setMetrics(dto.getMetrics());
        itemReport.setPlot(dto.getPlot());
        itemReport.setPartners(dto.getPartners());
        itemReport.setInterpretation(dto.getInterpretations());

        itemReportRepository.save(itemReport);

        return new ItemReportDto(
                itemReport.getMeta(),
                itemReport.getHeader(),
                itemReport.getLabelsNow(),
                itemReport.getMetrics(),
                itemReport.getPlot(),
                itemReport.getPartners(),
                itemReport.getInterpretation()
        );
    }

    public ItemReportDto getItemReport(String coupleCode, Integer itemId) {
        ItemReport itemReport = itemReportRepository.findByCoupleCodeAndItemId(coupleCode, itemId)
                .orElseThrow(() -> new RuntimeException("아이템 리포트 없음"));

        return new ItemReportDto(
                itemReport.getMeta(),
                itemReport.getHeader(),
                itemReport.getLabelsNow(),
                itemReport.getMetrics(),
                itemReport.getPlot(),
                itemReport.getPartners(),
                itemReport.getInterpretation()
        );
    }


}
