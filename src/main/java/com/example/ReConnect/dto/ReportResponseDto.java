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
    private JsonNode attachmentTheory;
    private JsonNode defenseMechanism;
    private JsonNode thinkingPattern;
    private JsonNode strengthTheory;
    private JsonNode selfDetermination;
    private JsonNode secureBase;

    public ReportResponseDto(String reportTitle,
                             JsonNode keyEmotions,
                             JsonNode coreKeywords,
                             JsonNode indicatorTrends,
                             JsonNode currentAnalysis,
                             JsonNode solution,
                             String feedbackAndCheer,
                             String repetitivePattern,
                             String recommendation,
                             JsonNode attachmentTheory,
                             JsonNode defenseMechanism,
                             JsonNode thinkingPattern,
                             JsonNode strengthTheory,
                             JsonNode selfDetermination,
                             JsonNode secureBase) {
        this.reportTitle = reportTitle;
        this.keyEmotions = keyEmotions;
        this.coreKeywords = coreKeywords;
        this.indicatorTrends = indicatorTrends;
        this.currentAnalysis = currentAnalysis;
        this.solution = solution;
        this.feedbackAndCheer = feedbackAndCheer;
        this.repetitivePattern = repetitivePattern;
        this.recommendation = recommendation;
        this.attachmentTheory = attachmentTheory;
        this.defenseMechanism = defenseMechanism;
        this.thinkingPattern = thinkingPattern;
        this.strengthTheory = strengthTheory;
        this.selfDetermination = selfDetermination;
        this.secureBase = secureBase;
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
    public JsonNode getAttachmentTheory() { return attachmentTheory; }
    public JsonNode getDefenseMechanism() { return defenseMechanism; }
    public JsonNode getThinkingPattern() { return thinkingPattern; }
    public JsonNode getStrengthTheory() { return strengthTheory; }
    public JsonNode getSelfDetermination() { return selfDetermination; }
    public JsonNode getSecureBase() { return secureBase; }
}
