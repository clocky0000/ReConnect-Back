package com.example.ReConnect.service;

import com.example.ReConnect.dto.DiaryRequestDto;
import com.example.ReConnect.dto.UserDto;
import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.repository.DiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserService userService;

    public DiaryService(DiaryRepository diaryRepository, UserService userService) {
        this.diaryRepository = diaryRepository;
        this.userService = userService;
    }

    public void submitDiary(DiaryRequestDto dto, String userId, String coupleCode, Integer questionNumber) {
        UserDto user = userService.findById(userId);

        if (user.getPartnerId() == null || user.getPartnerId().isEmpty()) {
            throw new IllegalStateException("연인이 연결되어 있어야 일기를 작성할 수 있습니다.");
        }

        // 이미 작성된 일기 체크
        boolean exists = diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(userId, coupleCode, questionNumber).isPresent();
        if (exists) {
            throw new IllegalStateException("이미 작성된 일기입니다.");
        }

        if (questionNumber > 1) {
            int prevQuestionNumber = questionNumber - 1;

            // 이전 문항
            Diary myPrevDiary = diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(userId, coupleCode, prevQuestionNumber)
                    .orElse(null);
            if (myPrevDiary == null) {
                throw new IllegalStateException("이전 문항을 먼저 작성해주세요.");
            }

            // 파트너
            String partnerId = user.getPartnerId();
            Diary partnerPrevDiary = diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(partnerId, coupleCode, prevQuestionNumber)
                    .orElse(null);
            if (partnerPrevDiary == null) {
                throw new IllegalStateException("연인이 이전 문항을 작성해야 다음 문항을 작성할 수 있습니다.");
            }
        }

        Diary diary = new Diary();
        diary.setUserId(userId);
        diary.setCoupleCode(coupleCode);
        diary.setQuestionNumber(questionNumber);
        diary.setContent(dto.getContent());
        diaryRepository.save(diary);
    }

    public int getLastCompletedQuestion(String coupleCode) {
        var page1 = PageRequest.of(0, 1);
        var list = diaryRepository.findCompletedQuestionNumbers(coupleCode, page1);
        return list.isEmpty() ? 0 : list.get(0);
    }

    /** 다음 질문 번호(최대 36로 제한). 둘 다 완료한 마지막 번호 + 1 */
    public int getNextQuestionNumber(String coupleCode) {
        int last = getLastCompletedQuestion(coupleCode);
        int next = last + 1;
        if (next > 36) next = 36;
        return next;
    }

    public DiaryRequestDto getDiary(String userId, String coupleCode, Integer questionNumber) {
        Diary diary = diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(userId, coupleCode, questionNumber)
                .orElse(null);
        if (diary == null) {
            return null;
        }

        return new DiaryRequestDto(diary.getUserId(), diary.getCoupleCode(), diary.getQuestionNumber(), diary.getContent());
    }

    public Diary getDiaryEntity(String userId, String coupleCode, Integer questionNumber) {
        return diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(userId, coupleCode, questionNumber)
                .orElseThrow(() -> new RuntimeException("해당 일기를 찾을 수 없습니다."));
    }

    public DiaryRequestDto getPartnerDiary(String partnerId, String coupleCode, Integer questionNumber) {
        if (partnerId == null || partnerId.isEmpty()) {
            throw new IllegalStateException("연인을 먼저 지정해주세요.");
        }

        Diary partnerDiary = diaryRepository.findByUserIdAndCoupleCodeAndQuestionNumber(partnerId, coupleCode, questionNumber)
                .orElse(null);
        if (partnerDiary == null) {
            return null;
        }

        return new DiaryRequestDto(
                partnerDiary.getUserId(),
                partnerDiary.getCoupleCode(),
                partnerDiary.getQuestionNumber(),
                partnerDiary.getContent()
        );
    }
}
