package com.example.ReConnect.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class ReportRequestDto {
    private String userId;
    private String date;
    private String inputText;

    @JsonProperty("report_title")
    private String reportTitle;

    @JsonProperty("key_emotions")
    private JsonNode keyEmotions;

    @JsonProperty("core_keywords")
    private JsonNode coreKeywords;

    @JsonProperty("indicator_trends")
    private JsonNode indicatorTrends;

    @JsonProperty("current_analysis")
    private JsonNode currentAnalysis;

    @JsonProperty("solution")
    private JsonNode solution;

    @JsonProperty("feedback_and_cheer")
    private String feedbackAndCheer;

    @JsonProperty("repetitive_pattern")
    private String repetitivePattern;

    private String recommendation;

    // Getter and Setter
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getInputText() {
        return inputText;
    }
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public String getReportTitle() { return reportTitle; }
    public void setReportTitle(String reportTitle) { this.reportTitle = reportTitle; }

    public JsonNode getKeyEmotions() { return keyEmotions; }
    public void setKeyEmotions(JsonNode keyEmotions) { this.keyEmotions = keyEmotions; }

    public JsonNode getCoreKeywords() { return coreKeywords; }
    public void setCoreKeywords(JsonNode coreKeywords) { this.coreKeywords = coreKeywords; }

    public JsonNode getIndicatorTrends() { return indicatorTrends; }
    public void setIndicatorTrends(JsonNode indicatorTrends) { this.indicatorTrends = indicatorTrends; }

    public JsonNode getCurrentAnalysis() { return currentAnalysis; }
    public void setCurrentAnalysis(JsonNode currentAnalysis) { this.currentAnalysis = currentAnalysis; }

    public JsonNode getSolution() { return solution; }
    public void setSolution(JsonNode solution) { this.solution = solution; }

    public String getFeedbackAndCheer() { return feedbackAndCheer; }
    public void setFeedbackAndCheer(String feedbackAndCheer) { this.feedbackAndCheer = feedbackAndCheer; }

    public String getRepetitivePattern() { return repetitivePattern; }
    public void setRepetitivePattern(String repetitivePattern) { this.repetitivePattern = repetitivePattern; }

    public String getRecommendation() { return recommendation; }
    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }
}

