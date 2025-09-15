package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
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
    private JsonNode summary;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("time_series")
    private JsonNode timeSeries;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode profiles;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("final_combination")
    private JsonNode finalCombination;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode recommendations;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode audit;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode appendix;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode lineage;

    public FinalReport() {}

    // Getters and Setters
    public Long getVectorId() { return vectorId; }
    public void setVectorId(Long vectorId) { this.vectorId = vectorId; }

    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

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
