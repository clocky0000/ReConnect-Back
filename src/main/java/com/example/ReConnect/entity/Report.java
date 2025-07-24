package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    // 일기 텍스트 밖으로
    @Column(columnDefinition = "TEXT")
    private String inputText;

    @Column(name = "report_title", columnDefinition = "TEXT")
    private String reportTitle;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("key_emotions")
    private JsonNode keyEmotions;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("core_keywords")
    private JsonNode coreKeywords;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("indicator_trends")
    private JsonNode indicatorTrends;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("current_analysis")
    private JsonNode currentAnalysis;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode solution;

    @Column(name = "feedback_and_cheer", columnDefinition = "TEXT")
    private String feedbackAndCheer;

    @Column(name = "repetitive_pattern", columnDefinition = "TEXT")
    private String repetitivePattern;

    @Column(columnDefinition = "TEXT")
    private String recommendation;

    public Report() {}

    // Getters
    public Long getVectorId() {
        return vectorId;
    }
    public String getUserId() {
        return userId;
    }
    public LocalDate getDate() { return date; }
    public String getInputText() { return inputText; }
    public String getReportTitle() { return reportTitle; }
    public JsonNode getKeyEmotions() { return keyEmotions; }
    public JsonNode getCoreKeywords() { return coreKeywords; }
    public JsonNode getIndicatorTrends() { return indicatorTrends; }
    public JsonNode getCurrentAnalysis() { return currentAnalysis; }
    public JsonNode getSolution() { return solution; }
    public String getFeedbackAndCheer() { return feedbackAndCheer; }
    public String getRepetitivePattern() { return repetitivePattern; }
    public String getRecommendation() { return recommendation; }

    // Setters
    public void setVectorId(Long vectorId) { this.vectorId = vectorId; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setInputText(String inputText) { this.inputText = inputText; }
    public void setReportTitle(String reportTitle) { this.reportTitle = reportTitle; }
    public void setKeyEmotions(JsonNode keyEmotions) { this.keyEmotions = keyEmotions; }
    public void setCoreKeywords(JsonNode coreKeywords) { this.coreKeywords = coreKeywords; }
    public void setIndicatorTrends(JsonNode indicatorTrends) { this.indicatorTrends = indicatorTrends; }
    public void setCurrentAnalysis(JsonNode currentAnalysis) { this.currentAnalysis = currentAnalysis; }
    public void setSolution(JsonNode solution) { this.solution = solution; }
    public void setFeedbackAndCheer(String feedbackAndCheer) { this.feedbackAndCheer = feedbackAndCheer; }
    public void setRepetitivePattern(String repetitivePattern) { this.repetitivePattern = repetitivePattern; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}

