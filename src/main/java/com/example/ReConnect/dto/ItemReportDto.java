package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class ItemReportDto {

    @JsonProperty("item_id")
    private Integer itemId;

    @JsonProperty("idempotency_key")
    private String idempotencyKey;
    private JsonNode meta;
    private JsonNode question;
    private JsonNode partners;

    @JsonProperty("couple_profile")
    private JsonNode coupleProfile;
    private JsonNode charts;
    private JsonNode strengths;
    private JsonNode issues;
    private JsonNode advice;
    private JsonNode audit;

    public ItemReportDto() {}

    // Getters and Setters
    public ItemReportDto(JsonNode meta,
                         JsonNode question,
                         JsonNode partners,
                         JsonNode coupleProfile,
                         JsonNode charts,
                         JsonNode strengths,
                         JsonNode issues,
                         JsonNode advice,
                         JsonNode audit) {
        this.meta = meta;
        this.question = question;
        this.partners = partners;
        this.coupleProfile = coupleProfile;
        this.charts = charts;
        this.strengths = strengths;
        this.issues = issues;
        this.advice = advice;
        this.audit = audit;
    }

    public Integer getItemId() { return itemId; }
    public void setItemId(Integer itemId) { this.itemId = itemId; }

    public String getIdempotencyKey() { return idempotencyKey; }
    public void setIdempotencyKey(String idempotencyKey) { this.idempotencyKey = idempotencyKey; }

    public JsonNode getMeta() { return meta; }
    public void setMeta(JsonNode meta) { this.meta = meta; }

    public JsonNode getQuestion() { return question; }
    public void setQuestion(JsonNode question) { this.question = question; }

    public JsonNode getPartners() { return partners; }
    public void setPartners(JsonNode partners) { this.partners = partners; }

    public JsonNode getCoupleProfile() { return coupleProfile; }
    public void setCoupleProfile(JsonNode coupleProfile) { this.coupleProfile = coupleProfile; }

    public JsonNode getCharts() { return charts; }
    public void setCharts(JsonNode charts) { this.charts = charts; }

    public JsonNode getStrengths() { return strengths; }
    public void setStrengths(JsonNode strengths) { this.strengths = strengths; }

    public JsonNode getIssues() { return issues; }
    public void setIssues(JsonNode issues) { this.issues = issues; }

    public JsonNode getAdvice() { return advice; }
    public void setAdvice(JsonNode advice) { this.advice = advice; }

    public JsonNode getAudit() { return audit; }
    public void setAudit(JsonNode audit) { this.audit = audit; }
}
