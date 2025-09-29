package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class FinalReportDto {
    private JsonNode meta;
    private JsonNode header;

    @JsonProperty("final_profiles")
    private JsonNode finalProfiles;

    @JsonProperty("delta_vs_baseline")
    private JsonNode deltaVsBaseline;

    private JsonNode plot;
    private JsonNode summary;

    @JsonProperty("final_interpretation")
    private JsonNode finalInterpretation;

    @JsonProperty("final_strengths")
    private JsonNode finalStrengths;

    @JsonProperty("final_issues")
    private JsonNode finalIssues;

    private JsonNode recommendations;

    @JsonProperty("time_series_summary")
    private JsonNode TimeSeriesSummary;

    public FinalReportDto() {}

    // Getters and Setters
    public FinalReportDto(JsonNode meta,
                          JsonNode header,
                          JsonNode finalProfiles,
                          JsonNode deltaVsBaseline,
                          JsonNode plot,
                          JsonNode summary,
                          JsonNode finalInterpretation,
                          JsonNode finalStrengths,
                          JsonNode finalIssues,
                          JsonNode recommendations,
                          JsonNode timeSeriesSummary) {
        this.meta = meta;
        this.header = header;
        this.finalProfiles = finalProfiles;
        this.deltaVsBaseline = deltaVsBaseline;
        this.plot = plot;
        this.summary = summary;
        this.finalInterpretation = finalInterpretation;
        this.finalStrengths = finalStrengths;
        this.finalIssues = finalIssues;
        this.recommendations = recommendations;
        this.TimeSeriesSummary = timeSeriesSummary;
    }

    public JsonNode getMeta() { return meta; }
    public void setMeta(JsonNode meta) { this.meta = meta; }

    public JsonNode getHeader() { return header; }
    public void setHeader(JsonNode header) { this.header = header; }

    public JsonNode getFinalProfiles() { return finalProfiles; }
    public void setFinalProfiles(JsonNode finalProfiles) { this.finalProfiles = finalProfiles; }

    public JsonNode getDeltaVsBaseline() { return deltaVsBaseline; }
    public void setDeltaVsBaseline(JsonNode deltaVsBaseline) { this.deltaVsBaseline = deltaVsBaseline; }

    public JsonNode getPlot() { return plot; }
    public void setPlot(JsonNode plot) { this.plot = plot; }

    public JsonNode getSummary() { return summary; }
    public void setSummary(JsonNode summary) { this.summary = summary; }

    public JsonNode getFinalInterpretation() { return finalInterpretation; }
    public void setFinalInterpretation(JsonNode finalInterpretation) { this.finalInterpretation = finalInterpretation; }

    public JsonNode getFinalStrengths() { return finalStrengths; }
    public void setFinalStrengths(JsonNode finalStrengths) { this.finalStrengths = finalStrengths; }

    public JsonNode getFinalIssues() { return finalIssues; }
    public void setFinalIssues(JsonNode finalIssues) { this.finalIssues = finalIssues; }

    public JsonNode getRecommendations() { return recommendations; }
    public void setRecommendations(JsonNode recommendations) { this.recommendations = recommendations; }

    public JsonNode getTimeSeriesSummary() { return TimeSeriesSummary; }
    public void setTimeSeriesSummary(JsonNode timeSeriesSummary) { this.TimeSeriesSummary = timeSeriesSummary; }
}
