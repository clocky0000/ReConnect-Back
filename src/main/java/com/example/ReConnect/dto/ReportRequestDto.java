package com.example.ReConnect.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class ReportRequestDto {
    private String userId;
    private String date;
    private String inputText;

    @JsonProperty("attachment_theory")
    private JsonNode attachmentTheory;

    @JsonProperty("defense_mechanism")
    private JsonNode defenseMechanism;

    @JsonProperty("thinking_mechanism")
    private JsonNode thinkingMechanism;

    @JsonProperty("strength_theory")
    private JsonNode strengthTheory;

    @JsonProperty("self_determination")
    private JsonNode selfDetermination;

    @JsonProperty("secure_base")
    private JsonNode secureBase;

    // Getter and Setter
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getInputText() {
        return inputText;
    }
    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public JsonNode getAttachmentTheory() { return attachmentTheory; }
    public void setAttachmentTheory(JsonNode attachmentTheory) { this.attachmentTheory = attachmentTheory; }

    public JsonNode getDefenseMechanism() { return defenseMechanism; }
    public void setDefenseMechanism(JsonNode defenseMechanism) { this.defenseMechanism = defenseMechanism; }

    public JsonNode getThinkingMechanism() { return thinkingMechanism; }
    public void setThinkingMechanism(JsonNode thinkingMechanism) { this.thinkingMechanism = thinkingMechanism; }

    public JsonNode getStrengthTheory() { return strengthTheory; }
    public void setStrengthTheory(JsonNode strengthTheory) { this.strengthTheory = strengthTheory; }

    public JsonNode getSelfDetermination() { return selfDetermination; }
    public void setSelfDetermination(JsonNode selfDetermination) { this.selfDetermination = selfDetermination; }

    public JsonNode getSecureBase() { return secureBase; }
    public void setSecureBase(JsonNode secureBase) { this.secureBase = secureBase; }

}

