package com.example.ReConnect.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vectorId;

    private String userId;
    private LocalDate date;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode analysisJson;

    public Report() {}

    public Long getVectorId() {
        return vectorId;
    }

    public String getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public JsonNode getAnalysisJson() {
        return analysisJson;
    }

    public void setVectorId(Long vectorId) {
        this.vectorId = vectorId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAnalysisJson(JsonNode analysisJson) {
        this.analysisJson = analysisJson;
    }
}

