package com.example.ReConnect.dto;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class ReportRequestDto {
    private String userId;
    private String date;
    private JsonNode analysisJson;
    private String inputText;
    private CorePrompt corePrompt;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public JsonNode getAnalysisJson() {
        return analysisJson;
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

    public CorePrompt getCorePrompt() {
        return corePrompt;
    }

    public void setCorePrompt(CorePrompt corePrompt) {
        this.corePrompt = corePrompt;
    }


    public static class CorePrompt {
        private String judgmentBasis;
        private List<String> alternativeExplanations;
        private String contextConsideration;

        public String getJudgmentBasis() {
            return judgmentBasis;
        }

        public void setJudgmentBasis(String judgmentBasis) {
            this.judgmentBasis = judgmentBasis;
        }

        public List<String> getAlternativeExplanations() {
            return alternativeExplanations;
        }

        public void setAlternativeExplanations(List<String> alternativeExplanations) {
            this.alternativeExplanations = alternativeExplanations;
        }

        public String getContextConsideration() {
            return contextConsideration;
        }

        public void setContextConsideration(String contextConsideration) {
            this.contextConsideration = contextConsideration;
        }
    }

}

