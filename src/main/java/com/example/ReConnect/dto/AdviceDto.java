package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdviceDto {

    private Long id;
    private String advice;

    @JsonProperty("advice_feature")
    private String adviceFeature;

    @JsonProperty("advice_sim")
    private String adviceSim;

    public AdviceDto() {}

    public AdviceDto(Long id, String advice, String adviceFeature, String adviceSim) {
        this.id = id;
        this.advice = advice;
        this.adviceFeature = adviceFeature;
        this.adviceSim = adviceSim;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdvice() { return advice; }
    public void setAdvice(String advice) { this.advice = advice; }

    public String getAdviceFeature() { return adviceFeature; }
    public void setAdviceFeature(String adviceFeature) { this.adviceFeature = adviceFeature; }

    public String getAdviceSim() { return adviceSim; }
    public void setAdviceSim(String adviceSim) { this.adviceSim = adviceSim; }
}
