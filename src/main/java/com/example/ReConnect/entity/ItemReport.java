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

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode meta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode header;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("labels_now")
    private JsonNode labelsNow;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode metrics;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode plot;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode partners;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private JsonNode interpretation;

    public ItemReport() {}

    // Getters and Setters
    public Long getVectorId() { return vectorId; }
    public void setVectorId(Long vectorId) { this.vectorId = vectorId; }

    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

    public Integer getItemId() { return itemId; }
    public void setItemId(Integer itemId) { this.itemId = itemId; }

    public JsonNode getMeta() { return meta; }
    public void setMeta(JsonNode meta) { this.meta = meta; }

    public JsonNode getHeader() { return header; }
    public void setHeader(JsonNode header) { this.header = header; }

    public JsonNode getLabelsNow() { return labelsNow; }
    public void setLabelsNow(JsonNode labelsNow) { this.labelsNow = labelsNow; }

    public JsonNode getMetrics() { return metrics; }
    public void setMetrics(JsonNode metrics) { this.metrics = metrics; }

    public JsonNode getPlot() { return plot; }
    public void setPlot(JsonNode plot) { this.plot = plot; }

    public JsonNode getPartners() { return partners; }
    public void setPartners(JsonNode partners) { this.partners = partners; }

    public JsonNode getInterpretation() { return interpretation; }
    public void setInterpretation(JsonNode interpretation) { this.interpretation = interpretation; }
}
