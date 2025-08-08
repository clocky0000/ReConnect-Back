package com.example.ReConnect.dto;

import java.time.LocalDate;

public class DiaryRequestDto {

    private String userId;
    private String title;
    private LocalDate date;
    private String content;

    public DiaryRequestDto() {}

    public DiaryRequestDto(String userId, LocalDate date, String title, String content) {
        this.userId = userId;
        this.date = date;
        this.title = title;
        this.content = content;
    }


    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
