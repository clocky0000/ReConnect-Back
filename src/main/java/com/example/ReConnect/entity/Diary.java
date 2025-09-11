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

    @Column(nullable = false)
    private String userId;

    // 연인 코드
    @Column(name = "couple_code", nullable = false, columnDefinition = "TEXT")
    private String coupleCode;

    // 문항 번호
    @Column(name = "question_number", nullable = false)
    private Integer questionNumber;

    @Convert(converter = EncryptedStringConverter.class)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    // 연관관계 필드 추가
    @OneToOne(mappedBy = "diary", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReportReasons reportReasons;

    @OneToOne(mappedBy = "diary", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReportScores reportScores;

    @OneToOne(mappedBy = "diary", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReportMetadata reportMetadata;

    @OneToOne(mappedBy = "diary", cascade = CascadeType.ALL, orphanRemoval = true)
    private Report report;

    @OneToOne(mappedBy = "diary", cascade = CascadeType.ALL, orphanRemoval = true)
    private ReportText reportText;

    public Diary() {}

    // Getters
    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public String getCoupleCode() { return coupleCode; }
    public Integer getQuestionNumber() { return questionNumber; }
    public String getContent() { return content; }

    public ReportReasons getReportReasons() { return reportReasons; }
    public ReportScores getReportScores() { return reportScores; }
    public ReportMetadata getReportMetadata() { return reportMetadata; }
    public Report getReport() { return report; }
    public ReportText getReportText() { return reportText; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }
    public void setQuestionNumber(Integer questionNumber) { this.questionNumber = questionNumber; }
    public void setContent(String content) { this.content = content; }
    public void setReportReasons(ReportReasons reportReasons) {
        this.reportReasons = reportReasons;
        if(reportReasons != null) {
            reportReasons.setDiary(this);
        }
    }
    public void setReportScores(ReportScores reportScores) {
        this.reportScores = reportScores;
        if(reportScores != null) {
            reportScores.setDiary(this);
        }
    }
    public void setReportMetadata(ReportMetadata reportMetadata) {
        this.reportMetadata = reportMetadata;
        if(reportMetadata != null) {
            reportMetadata.setDiary(this);
        }
    }
    public void setReport(Report report) {
        this.report = report;
        if(report != null) {
            report.setDiary(this);
        }
    }
    public void setReportText(ReportText reportText) {
        this.reportText = reportText;
        if(reportText != null) {
            reportText.setDiary(this);
        }
    }
}