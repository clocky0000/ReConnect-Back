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
    private JsonNode interpretation;

    public ItemReportDto() {}

    // Getters and Setters
    public ItemReportDto(JsonNode meta,
                         JsonNode header,
                         JsonNode labelsNow,
                         JsonNode metrics,
                         JsonNode plot,
                         JsonNode partners,
                         JsonNode interpretation) { //이원석 수정 interpretations -> interpretation
        this.meta = meta;
        this.header = header;
        this.labelsNow = labelsNow;
        this.metrics = metrics;
        this.plot = plot;
        this.partners = partners;
        this.interpretation = interpretation;
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

    // ItemReportDto.java (하단 교체)
    public JsonNode getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(JsonNode interpretation) {
        this.interpretation = interpretation;
    }

    /**
     * ✅ 하위호환용 (예전 Service 코드가 호출)
     *   - 기존 코드: dto.getInterpretations()
     *   - 새 DTO와 호환되도록 브릿지 메서드 제공
     */
    @Deprecated
    @JsonProperty("interpretations")
    public JsonNode getInterpretations() {
        return getInterpretation();
    }

    @Deprecated
    public void setInterpretations(JsonNode interpretations) {
        setInterpretation(interpretations);
    }

}
