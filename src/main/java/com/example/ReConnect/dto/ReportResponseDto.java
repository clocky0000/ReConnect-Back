package com.example.ReConnect.dto;

import com.fasterxml.jackson.databind.JsonNode;

public class ReportResponseDto {

    private JsonNode attachmentTheory;
    private JsonNode defenseMechanism;
    private JsonNode thinkingPattern;
    private JsonNode strengthTheory;
    private JsonNode selfDetermination;
    private JsonNode secureBase;

    public ReportResponseDto(JsonNode attachmentTheory,
                             JsonNode defenseMechanism,
                             JsonNode thinkingPattern,
                             JsonNode strengthTheory,
                             JsonNode selfDetermination,
                             JsonNode secureBase) {
        this.attachmentTheory = attachmentTheory;
        this.defenseMechanism = defenseMechanism;
        this.thinkingPattern = thinkingPattern;
        this.strengthTheory = strengthTheory;
        this.selfDetermination = selfDetermination;
        this.secureBase = secureBase;
    }

    // Getters
    public JsonNode getAttachmentTheory() { return attachmentTheory; }

    public JsonNode getDefenseMechanism() { return defenseMechanism; }

    public JsonNode getThinkingPattern() { return thinkingPattern; }

    public JsonNode getStrengthTheory() { return strengthTheory; }

    public JsonNode getSelfDetermination() { return selfDetermination; }

    public JsonNode getSecureBase() { return secureBase; }
}
