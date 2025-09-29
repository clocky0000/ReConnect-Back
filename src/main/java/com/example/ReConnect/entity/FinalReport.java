package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "final_reports")
public class FinalReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vectorId;

    @Column(name = "couple_code", nullable = false, columnDefinition = "TEXT")
    private String coupleCode;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode meta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode header;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("final_profiles")
    private JsonNode finalProfiles;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("delta_vs_baseline")
    private JsonNode deltaVsBaseline;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode plot;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode summary;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("final_interpretation")
    private JsonNode finalInterpretation;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("final_strengths")
    private JsonNode finalStrengths;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("final_issues")
    private JsonNode finalIssues;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode recommendations;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("time_series_summary")
    private JsonNode timeSeriesSummary;


    public FinalReport() {}

    // Getters and Setters
    public Long getVectorId() { return vectorId; }
    public void setVectorId(Long vectorId) { this.vectorId = vectorId; }

    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

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

    public JsonNode getTimeSeriesSummary() { return timeSeriesSummary; }
    public void setTimeSeriesSummary(JsonNode timeSeriesSummary) { this.timeSeriesSummary = timeSeriesSummary; }
}
