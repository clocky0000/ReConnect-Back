package com.example.ReConnect.service;

import com.example.ReConnect.dto.SurveyDto;
import com.example.ReConnect.entity.Survey;
import com.example.ReConnect.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    @Autowired
    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Transactional
    public void save(SurveyDto dto) {
        // 기존 (userId, coupleCode) 있으면 업데이트, 없으면 신규 생성
        Survey s = surveyRepository.findByUserIdAndCoupleCode(dto.getUserId(), dto.getCoupleCode())
                .orElse(new Survey());
        s.setUserId(dto.getUserId());
        s.setCoupleCode(dto.getCoupleCode());

        s.setQ1(dto.getQ1()); s.setQ2(dto.getQ2()); s.setQ3(dto.getQ3()); s.setQ4(dto.getQ4()); s.setQ5(dto.getQ5());
        s.setQ6(dto.getQ6()); s.setQ7(dto.getQ7()); s.setQ8(dto.getQ8()); s.setQ9(dto.getQ9()); s.setQ10(dto.getQ10());
        s.setQ11(dto.getQ11()); s.setQ12(dto.getQ12()); s.setQ13(dto.getQ13()); s.setQ14(dto.getQ14()); s.setQ15(dto.getQ15());
        s.setQ16(dto.getQ16()); s.setQ17(dto.getQ17()); s.setQ18(dto.getQ18()); s.setQ19(dto.getQ19()); s.setQ20(dto.getQ20());
        s.setQ21(dto.getQ21()); s.setQ22(dto.getQ22()); s.setQ23(dto.getQ23()); s.setQ24(dto.getQ24()); s.setQ25(dto.getQ25());
        s.setQ26(dto.getQ26()); s.setQ27(dto.getQ27()); s.setQ28(dto.getQ28()); s.setQ29(dto.getQ29()); s.setQ30(dto.getQ30());
        s.setQ31(dto.getQ31()); s.setQ32(dto.getQ32()); s.setQ33(dto.getQ33()); s.setQ34(dto.getQ34()); s.setQ35(dto.getQ35()); s.setQ36(dto.getQ36());

        s.setTotalAnxiety(dto.getTotalAnxiety());
        s.setTotalAvoidance(dto.getTotalAvoidance());

        surveyRepository.save(s);
    }

    public SurveyDto getByUserIdAndCoupleCode(String userId, String coupleCode) {
        return surveyRepository.findByUserIdAndCoupleCode(userId, coupleCode)
                .map(SurveyDto::from)
                .orElse(null);
    }
}
