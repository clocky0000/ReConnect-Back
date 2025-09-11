package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportScoresDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportScores;
import com.example.ReConnect.repository.ReportScoresRepository;
import org.springframework.stereotype.Service;


@Service
public class ReportScoresService {

    private final ReportScoresRepository reportScoresRepository;

    public ReportScoresService(ReportScoresRepository reportScoresRepository) { this.reportScoresRepository = reportScoresRepository; }

    public ReportScoresDto getReportScores(Diary diary) {
        ReportScores reportScores = reportScoresRepository.findByDiary(diary)
                .orElseThrow(() -> new RuntimeException("해당 일기에 대한 점수를 찾을 수 없습니다"));

        return new ReportScoresDto(reportScores);
    }

    public void saveReportScores(ReportScoresDto reportScoresDto, Diary diary) {
        ReportScores reportScores = new ReportScores();
        reportScores.setUserId(diary.getUserId());
        //reportScores.setDate(diary.getDate());
        reportScores.setDiary(diary);
        reportScores.setPHQ8Scores(reportScoresDto.getPHQ8Scores());
        reportScores.setGAD7Scores(reportScoresDto.getGAD7Scores());
        reportScores.setBAIScores(reportScoresDto.getBAIScores());
        reportScores.setECRRScores(reportScoresDto.getECRRScores());
        reportScores.setVIAScores(reportScoresDto.getVIAScores());
        reportScores.setSDTScores(reportScoresDto.getSDTScores());
        reportScores.setSecureBaseScore(reportScoresDto.getSecureBaseScore());

        reportScoresRepository.save(reportScores);
    }
}
