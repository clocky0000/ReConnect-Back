package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportReasonsDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportReasons;
import com.example.ReConnect.repository.ReportReasonsRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportReasonsService {

    private final ReportReasonsRepository reportReasonsRepository;

    public ReportReasonsService(ReportReasonsRepository reportReasonsRepository) { this.reportReasonsRepository = reportReasonsRepository; }

    public ReportReasonsDto getReportReasons(Diary diary) {
        ReportReasons reportReasons = reportReasonsRepository.findByDiary(diary)
                .orElseThrow(() -> new RuntimeException("해당 일기에 대한 이유를 찾을 수 없습니다"));

        return new ReportReasonsDto(reportReasons);
    }

    public void saveReportReasons(ReportReasonsDto reportReasonsDto, Diary diary) {
        ReportReasons reportReasons = new ReportReasons();
        reportReasons.setUserId(diary.getUserId());
        //reportReasons.setDate(diary.getDate());
        reportReasons.setDiary(diary);
        reportReasons.setKeyEmotions(reportReasonsDto.getKeyEmotions());
        reportReasons.setCoreKeywords(reportReasonsDto.getCoreKeywords());
        reportReasons.setPHQ8Reasons(reportReasonsDto.getPHQ8Reasons());
        reportReasons.setGAD7Reasons(reportReasonsDto.getGAD7Reasons());
        reportReasons.setBAIReasons(reportReasonsDto.getBAIReasons());
        reportReasons.setECRReasons(reportReasonsDto.getECRReasons());
        reportReasons.setVIAReasons(reportReasonsDto.getVIAReasons());
        reportReasons.setSDTReasons(reportReasonsDto.getSDTReasons());
        reportReasons.setDefenseMechanismReasons(reportReasonsDto.getDefenseMechanismReasons());
        reportReasons.setSecureBaseReasons(reportReasonsDto.getSecureBaseReasons());

        reportReasonsRepository.save(reportReasons);
    }
}
