package com.example.ReConnect.dto;

import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportMetadata;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class ReportMetadataDto {

    private Long id;
    private String userId;
    private LocalDate date;
    private Long diaryId;

    @JsonProperty("PHQ_8_meta")
    private JsonNode PHQ8Meta;

    @JsonProperty("GAD_7_meta")
    private JsonNode GAD7Meta;

    @JsonProperty("BAI_meta")
    private JsonNode BAIMeta;

    @JsonProperty("ECR_R_meta")
    private JsonNode ECRRMeta;

    @JsonProperty("VIA_meta")
    private JsonNode VIAMeta;

    @JsonProperty("SDT_meta")
    private JsonNode SDTMeta;

    @JsonProperty("Psychoanalytic_meta")
    private JsonNode PsychoanalyticMeta;

    @JsonProperty("SecureBase_meta")
    private JsonNode SecureBaseMeta;

    public ReportMetadataDto() {}

    public ReportMetadataDto(ReportMetadata reportMetadata) {
        this.userId = reportMetadata.getUserId();
        this.date = reportMetadata.getDate();
        this.diaryId = reportMetadata.getDiary().getId();
        this.PHQ8Meta = reportMetadata.getPHQ8Meta();
        this.GAD7Meta = reportMetadata.getGAD7Meta();
        this.BAIMeta = reportMetadata.getBAIMeta();
        this.ECRRMeta = reportMetadata.getECRRMeta();
        this.VIAMeta = reportMetadata.getVIAMeta();
        this.SDTMeta = reportMetadata.getSDTMeta();
        this.PsychoanalyticMeta = reportMetadata.getPsychoanalyticMeta();
        this.SecureBaseMeta = reportMetadata.getSecureBaseMeta();
    }

    public String getUserId() { return userId; }
    public LocalDate getDate() { return date; }
    public Long getDiaryId() { return diaryId; }

    @JsonIgnore
    public JsonNode getPHQ8Meta() { return PHQ8Meta; }

    @JsonIgnore
    public JsonNode getGAD7Meta() { return GAD7Meta; }

    @JsonIgnore
    public JsonNode getBAIMeta() { return BAIMeta; }

    @JsonIgnore
    public JsonNode getECRRMeta() { return ECRRMeta; }

    @JsonIgnore
    public JsonNode getVIAMeta() { return VIAMeta; }

    @JsonIgnore
    public JsonNode getSDTMeta() { return SDTMeta; }

    @JsonIgnore
    public JsonNode getPsychoanalyticMeta() { return PsychoanalyticMeta; }

    @JsonIgnore
    public JsonNode getSecureBaseMeta() { return SecureBaseMeta; }
}
