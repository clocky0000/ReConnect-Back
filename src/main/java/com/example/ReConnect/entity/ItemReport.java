package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "item_reports",
        uniqueConstraints = @UniqueConstraint(columnNames = {"couple_code", "item_id"}))
public class ItemReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vectorId;

    @Column(name = "couple_code", nullable = false, columnDefinition = "TEXT")
    private String coupleCode;

    @Column(name = "item_id", nullable = false)
    private Integer itemId;

    @Column(name = "idempotency_key", nullable = false, columnDefinition = "TEXT", unique = true)
    private String idempotencyKey;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode meta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode question;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode partners;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("couple_profile")
    private JsonNode coupleProfile;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode charts;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode strengths;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode issues;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode advice;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode audit;

    public ItemReport() {}

    // Getters and Setters
    public Long getVectorId() { return vectorId; }
    public void setVectorId(Long vectorId) { this.vectorId = vectorId; }

    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

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
