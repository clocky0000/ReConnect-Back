package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class ItemReportDto {

    @JsonProperty("item_id")
    private Integer itemId;

    private JsonNode meta;
    private JsonNode header;

    @JsonProperty("labels_now")
    private JsonNode labelsNow;

    private JsonNode metrics;
    private JsonNode plot;
    private JsonNode partners;
    private JsonNode interpretations;

    public ItemReportDto() {}

    // Getters and Setters
    public ItemReportDto(JsonNode meta,
                         JsonNode header,
                         JsonNode labelsNow,
                         JsonNode metrics,
                         JsonNode plot,
                         JsonNode partners,
                         JsonNode interpretations) {
        this.meta = meta;
        this.header = header;
        this.labelsNow = labelsNow;
        this.metrics = metrics;
        this.plot = plot;
        this.partners = partners;
        this.interpretations = interpretations;
    }

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

    public JsonNode getInterpretations() { return interpretations; }
    public void setInterpretations(JsonNode interpretations) { this.interpretations = interpretations; }
}
