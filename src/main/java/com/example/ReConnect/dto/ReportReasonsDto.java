package com.example.ReConnect.dto;

import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportReasons;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class ReportReasonsDto {

    private Long id;
    private String userId;
    private LocalDate date;
    private Long diaryId;

    @JsonProperty("key_emotions")
    private JsonNode keyEmotions;

    @JsonProperty("core_keywords")
    private JsonNode coreKeywords;

    @JsonProperty("PHQ_8_reasons")
    private JsonNode PHQ8Reasons;

    @JsonProperty("GAD_7_reasons")
    private JsonNode GAD7Reasons;

    @JsonProperty("BAI_reasons")
    private JsonNode BAIReasons;

    @JsonProperty("ECR_R_reasons")
    private JsonNode ECRReasons;

    @JsonProperty("VIA_reasons")
    private JsonNode VIAReasons;

    @JsonProperty("SDT_reasons")
    private JsonNode SDTReasons;

    @JsonProperty("DefenseMechanism_reasons")
    private JsonNode DefenseMechanismReasons;

    @JsonProperty("SecureBase_reasons")
    private JsonNode SecureBaseReasons;

    public ReportReasonsDto() {}

    public ReportReasonsDto(ReportReasons reportReasons) {
        this.userId = reportReasons.getUserId();
        this.date = reportReasons.getDate();
        this.diaryId = reportReasons.getDiary().getId();
        this.keyEmotions = reportReasons.getKeyEmotions();
        this.coreKeywords = reportReasons.getCoreKeywords();
        this.PHQ8Reasons = reportReasons.getPHQ8Reasons();
        this.GAD7Reasons = reportReasons.getGAD7Reasons();
        this.BAIReasons = reportReasons.getBAIReasons();
        this.ECRReasons = reportReasons.getECRReasons();
        this.VIAReasons = reportReasons.getVIAReasons();
        this.SDTReasons = reportReasons.getSDTReasons();
        this.DefenseMechanismReasons = reportReasons.getDefenseMechanismReasons();
        this.SecureBaseReasons = reportReasons.getSecureBaseReasons();
    }

    public String getUserId() { return userId; }
    public LocalDate getDate() { return date; }
    public Long getDiaryId() { return diaryId; }

    @JsonIgnore
    public JsonNode getKeyEmotions() { return keyEmotions; }

    @JsonIgnore
    public JsonNode getCoreKeywords() { return coreKeywords; }

    @JsonIgnore
    public JsonNode getPHQ8Reasons() { return PHQ8Reasons; }

    @JsonIgnore
    public JsonNode getGAD7Reasons() { return GAD7Reasons; }

    @JsonIgnore
    public JsonNode getBAIReasons() { return BAIReasons; }

    @JsonIgnore
    public JsonNode getECRReasons() { return ECRReasons; }

    @JsonIgnore
    public JsonNode getVIAReasons() { return VIAReasons; }

    @JsonIgnore
    public JsonNode getSDTReasons() { return SDTReasons; }

    @JsonIgnore
    public JsonNode getDefenseMechanismReasons() { return DefenseMechanismReasons; }

    @JsonIgnore
    public JsonNode getSecureBaseReasons() { return SecureBaseReasons; }
}
