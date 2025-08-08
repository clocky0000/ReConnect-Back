package com.example.ReConnect.service;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public void submitDiary(DiaryRequestDto dto, String userId) {
        LocalDate today = LocalDate.now();
        LocalDate diaryDate = dto.getDate();
        
        // 날짜 검증: 최대 3일 전까지 일기 작성 가능
        if(diaryDate.isBefore(today.minusDays(3)) || diaryDate.isAfter(today)) {
            throw new IllegalArgumentException("일기는 최대 3일 전까지만 작성 가능");
        }

        Diary diary = new Diary();
        diary.setUserId(userId);
        diary.setTitle(dto.getTitle());
        diary.setDate(dto.getDate());
        diary.setContent(dto.getContent());
        diaryRepository.save(diary);
    }

    public DiaryRequestDto getDiary(String userId, LocalDate date) {
        Diary diary = diaryRepository.findByUserIdAndDate(userId, date)
                .orElseThrow(() -> new RuntimeException("해당 일기를 찾을 수 없습니다."));

        return new DiaryRequestDto(diary.getUserId(), diary.getDate(), diary.getTitle(), diary.getContent());
    }

}
