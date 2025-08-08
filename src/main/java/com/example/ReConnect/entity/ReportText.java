package com.example.ReConnect.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "report_text")
public class ReportText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private LocalDate date;

    // 연결된 일기
    @OneToOne
    @JoinColumn(name = "diary_id", referencedColumnName = "id", nullable = false, unique = true)
    private Diary diary;

    // 분석 줄글
    @Column(columnDefinition = "TEXT")
    private String reportText;

    // 지표 척도
    private Float stress;
    private Float energy;
    private Float emotion;
    private Float depression;
    private Float anxiety;

    public ReportText() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Diary getDiary() { return diary; }
    public void setDiary(Diary diary) { this.diary = diary; }

    public String getReportText() { return reportText; }
    public void setReportText(String reportText) { this.reportText = reportText; }

    public Float getStress() { return stress; }
    public void setStress(Float stress) { this.stress = stress; }

    public Float getEnergy() { return energy; }
    public void setEnergy(Float energy) { this.energy = energy; }

    public Float getEmotion() { return emotion; }
    public void setEmotion(Float emotion) { this.emotion = emotion; }

    public Float getDepression() { return depression; }
    public void setDepression(Float depression) { this.depression = depression; }

    public Float getAnxiety() { return anxiety; }
    public void setAnxiety(Float anxiety) { this.anxiety = anxiety; }
}
