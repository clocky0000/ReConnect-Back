package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportMetadataDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportMetadata;
import com.example.ReConnect.repository.ReportMetadataRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportMetadataService {

    private final ReportMetadataRepository reportMetadataRepository;

    public ReportMetadataService(ReportMetadataRepository reportMetadataRepository) { this.reportMetadataRepository = reportMetadataRepository; }

    public ReportMetadataDto getReportMeta(Diary diary) {
        ReportMetadata reportMetadata = reportMetadataRepository.findByDiary(diary)
                .orElseThrow(() -> new RuntimeException("해당 일기에 대한 메타데이터를 찾을 수 없습니다"));

        return new ReportMetadataDto(reportMetadata);
    }

    public void saveReportMetadata(ReportMetadataDto reportMetadataDto, Diary diary) {
        ReportMetadata reportMetadata = new ReportMetadata();
        reportMetadata.setUserId(diary.getUserId());
        //reportMetadata.setDate(diary.getDate());
        reportMetadata.setDiary(diary);
        reportMetadata.setPHQ8Meta(reportMetadataDto.getPHQ8Meta());
        reportMetadata.setGAD7Meta(reportMetadataDto.getGAD7Meta());
        reportMetadata.setBAIMeta(reportMetadataDto.getBAIMeta());
        reportMetadata.setECRRMeta(reportMetadataDto.getECRRMeta());
        reportMetadata.setVIAMeta(reportMetadataDto.getVIAMeta());
        reportMetadata.setSDTMeta(reportMetadataDto.getSDTMeta());
        reportMetadata.setPsychoanalyticMeta(reportMetadataDto.getPsychoanalyticMeta());
        reportMetadata.setSecureBaseMeta(reportMetadataDto.getSecureBaseMeta());

        reportMetadataRepository.save(reportMetadata);
    }
}
