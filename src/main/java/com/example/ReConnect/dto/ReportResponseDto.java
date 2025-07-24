package com.example.ReConnect.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class ReportResponseDto {

    private String reportTitle;
    private JsonNode keyEmotions;
    private JsonNode coreKeywords;
    private JsonNode indicatorTrends;
    private JsonNode currentAnalysis;
    private JsonNode solution;
    private String feedbackAndCheer;
    private String repetitivePattern;
    private String recommendation;

    public ReportResponseDto(String reportTitle,
                             JsonNode keyEmotions,
                             JsonNode coreKeywords,
                             JsonNode indicatorTrends,
                             JsonNode currentAnalysis,
                             JsonNode solution,
                             String feedbackAndCheer,
                             String repetitivePattern,
                             String recommendation) {
        this.reportTitle = reportTitle;
        this.keyEmotions = keyEmotions;
        this.coreKeywords = coreKeywords;
        this.indicatorTrends = indicatorTrends;
        this.currentAnalysis = currentAnalysis;
        this.solution = solution;
        this.feedbackAndCheer = feedbackAndCheer;
        this.repetitivePattern = repetitivePattern;
        this.recommendation = recommendation;
    }

    // Getters
    public String getReportTitle() { return reportTitle; }
    public JsonNode getKeyEmotions() { return keyEmotions; }
    public JsonNode getCoreKeywords() { return coreKeywords; }
    public JsonNode getIndicatorTrends() { return indicatorTrends; }
    public JsonNode getCurrentAnalysis() { return currentAnalysis; }
    public JsonNode getSolution() { return solution; }
    public String getFeedbackAndCheer() { return feedbackAndCheer; }
    public String getRepetitivePattern() { return repetitivePattern; }
    public String getRecommendation() { return recommendation; }
}
