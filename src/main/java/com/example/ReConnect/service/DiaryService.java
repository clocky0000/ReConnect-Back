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

    public void submitDiary(DiaryRequestDto dto) {
        Diary diary = new Diary();
        diary.setUserId(dto.getUserId());
        diary.setTitle(dto.getTitle());
        diary.setDate(dto.getDate());
        diary.setContent(dto.getContent());
        diary.setSubmitted(true);
        diaryRepository.save(diary);
    }

    public DiaryRequestDto getDiary(String userId, LocalDate date) {
        Diary diary = diaryRepository.findByUserIdAndDate(userId, date)
                .orElseThrow(() -> new RuntimeException("해당 일기를 찾을 수 없습니다."));

        return new DiaryRequestDto(diary.getUserId(), diary.getDate(), diary.getTitle(), diary.getContent());
    }

}
