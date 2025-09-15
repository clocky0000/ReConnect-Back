package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class FinalReportDto {
    private JsonNode summary;

    @JsonProperty("time_series")
    private JsonNode timeSeries;

    private JsonNode profiles;

    @JsonProperty("final_combination")
    private JsonNode finalCombination;

    private JsonNode recommendations;
    private JsonNode audit;
    private JsonNode appendix;
    private JsonNode lineage;

    public FinalReportDto() {}

    // Getters and Setters
    public FinalReportDto(JsonNode summary,
                          JsonNode timeSeries,
                          JsonNode profiles,
                          JsonNode finalCombination,
                          JsonNode recommendations,
                          JsonNode audit,
                          JsonNode appendix,
                          JsonNode lineage) {
        this.summary = summary;
        this.timeSeries = timeSeries;
        this.profiles = profiles;
        this.finalCombination = finalCombination;
        this.recommendations = recommendations;
        this.audit = audit;
        this.appendix = appendix;
        this.lineage = lineage;
    }

    public JsonNode getSummary() { return summary; }
    public void setSummary(JsonNode summary) { this.summary = summary; }

    public JsonNode getTimeSeries() { return timeSeries; }
    public void setTimeSeries(JsonNode timeSeries) { this.timeSeries = timeSeries; }

    public JsonNode getProfiles() { return profiles; }
    public void setProfiles(JsonNode profiles) { this.profiles = profiles; }

    public JsonNode getFinalCombination() { return finalCombination; }
    public void setFinalCombination(JsonNode finalCombination) { this.finalCombination = finalCombination; }

    public JsonNode getRecommendations() { return recommendations; }
    public void setRecommendations(JsonNode recommendations) { this.recommendations = recommendations; }

    public JsonNode getAudit() { return audit; }
    public void setAudit(JsonNode audit) { this.audit = audit; }

    public JsonNode getAppendix() { return appendix; }
    public void setAppendix(JsonNode appendix) { this.appendix = appendix; }

    public JsonNode getLineage() { return lineage; }
    public void setLineage(JsonNode lineage) { this.lineage = lineage; }
}
