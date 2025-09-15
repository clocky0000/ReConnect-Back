package com.example.ReConnect.entity;

import jakarta.persistence.*;
import com.example.ReConnect.persistence.EncryptedStringConverter;

import java.time.LocalDate;

@Entity
@Table(name = "diaries")
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    // 연인 코드
    @Column(name = "couple_code", nullable = false, columnDefinition = "TEXT")
    private String coupleCode;

    // 문항 번호
    @Column(name = "item_id", nullable = false)
    private Integer questionNumber;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    public Diary() {}

    // Getters
    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public String getCoupleCode() { return coupleCode; }
    public Integer getQuestionNumber() { return questionNumber; }
    public String getContent() { return content; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }
    public void setQuestionNumber(Integer questionNumber) { this.questionNumber = questionNumber; }
    public void setContent(String content) { this.content = content; }

}