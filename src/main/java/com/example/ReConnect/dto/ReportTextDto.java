package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDate;

public class ReportTextDto {

    private Long id;
    private String userId;
    private LocalDate date;
    private String reportText;
    private Float stress;
    private Float energy;
    private Float emotion;
    private Float depression;
    private Float anxiety;

    public ReportTextDto(String userId,
                         LocalDate date,
                         String reportText,
                         Float stress,
                         Float energy,
                         Float emotion,
                         Float depression,
                         Float anxiety) {
        this.userId = userId;
        this.date = date;
        this.reportText = reportText;
        this.stress = stress;
        this.energy = energy;
        this.emotion = emotion;
        this.depression = depression;
        this.anxiety = anxiety;
    }

    // Getters and Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

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
