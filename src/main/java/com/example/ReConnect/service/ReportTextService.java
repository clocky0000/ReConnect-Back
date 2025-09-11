package com.example.ReConnect.service;

import com.example.ReConnect.dto.ReportTextDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportText;
import com.example.ReConnect.repository.DiaryRepository;
import com.example.ReConnect.repository.ReportTextRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReportTextService {

    private final ReportTextRepository reportTextRepository;
    private final DiaryRepository diaryRepository;

    public ReportTextService(ReportTextRepository reportTextRepository, DiaryRepository diaryRepository) {
        this.reportTextRepository = reportTextRepository;
        this.diaryRepository = diaryRepository;
    }

//    public ReportTextDto getReportText(String userId, LocalDate date) {
//        ReportText reportText = reportTextRepository.findByUserIdAndDate(userId, date)
//                .orElseThrow(() -> new RuntimeException("텍스트 및 지표 없음"));
//        return new ReportTextDto(
//                reportText.getUserId(),
//                reportText.getDate(),
//                reportText.getReportText(),
//                reportText.getStress(),
//                reportText.getEnergy(),
//                reportText.getEmotion(),
//                reportText.getDepression(),
//                reportText.getAnxiety()
//        );
//    }
//
//    public void saveReportText(ReportTextDto reportTextDto, String userId) {
//        ReportText reportText = new ReportText();
//
//        reportText.setUserId(userId);
//        LocalDate date = reportTextDto.getDate();
//        reportText.setDate(date);
//
//        Diary diary = diaryRepository.findByUserIdAndDate(userId, date)
//                        .orElseThrow(() -> new RuntimeException("해당 일기가 없습니다."));
//        reportText.setDiary(diary);
//
//        reportText.setReportText(reportTextDto.getReportText());
//        reportText.setStress(reportTextDto.getStress());
//        reportText.setEnergy(reportTextDto.getEnergy());
//        reportText.setEmotion(reportTextDto.getEmotion());
//        reportText.setDepression(reportTextDto.getDepression());
//        reportText.setAnxiety(reportTextDto.getAnxiety());
//
//        reportTextRepository.save(reportText);
//    }
}
