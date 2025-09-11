package com.example.ReConnect.dto;

import java.time.LocalDate;

public class DiaryRequestDto {

    private String userId;
    private String coupleCode;
    private Integer questionNumber;
    private String content;

    public DiaryRequestDto() {}

    public DiaryRequestDto(String userId, String coupleCode, Integer questionNumber, String content) {
        this.userId = userId;
        this.coupleCode = coupleCode;
        this.questionNumber = questionNumber;
        this.content = content;
    }


    public String getUserId() {
        return userId;
    }
    public String getCoupleCode() { return coupleCode; }
    public Integer getQuestionNumber() { return questionNumber; }
    public String getContent() {
        return content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }
    public void setQuestionNumber(Integer questionNumber) { this.questionNumber = questionNumber; }
    public void setContent(String content) {
        this.content = content;
    }
}
