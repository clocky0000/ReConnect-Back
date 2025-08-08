package com.example.ReConnect.dto;

import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportScores;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;

public class ReportScoresDto {

    private Long id;
    private String userId;
    private LocalDate date;
    private Long diaryId;

    @JsonProperty("PHQ_8_scores")
    private JsonNode PHQ8Scores;

    @JsonProperty("GAD_7_scores")
    private JsonNode GAD7Scores;

    @JsonProperty("BAI_scores")
    private JsonNode BAIScores;

    @JsonProperty("ECR_R_scores")
    private JsonNode ECRRScores;

    @JsonProperty("VIA_scores")
    private JsonNode VIAScores;

    @JsonProperty("SDT_scores")
    private JsonNode SDTScores;

    @JsonProperty("SecureBase_score")
    private Float SecureBaseScore;

    public ReportScoresDto() {}

    public ReportScoresDto(ReportScores reportScores) {
        this.userId = reportScores.getUserId();
        this.date = reportScores.getDate();
        this.diaryId = reportScores.getDiary().getId();
        this.PHQ8Scores = reportScores.getPHQ8Scores();
        this.GAD7Scores = reportScores.getGAD7Scores();
        this.BAIScores = reportScores.getBAIScores();
        this.ECRRScores = reportScores.getECRRScores();
        this.VIAScores = reportScores.getVIAScores();
        this.SDTScores = reportScores.getSDTScores();
        this.SecureBaseScore = reportScores.getSecureBaseScore();
    }

    public String getUserId() { return userId; }
    public LocalDate getDate() { return date; }
    public Long getDiaryId() { return diaryId; }

    @JsonIgnore
    public JsonNode getPHQ8Scores() { return PHQ8Scores; }

    @JsonIgnore
    public JsonNode getGAD7Scores() { return GAD7Scores; }

    @JsonIgnore
    public JsonNode getBAIScores() { return BAIScores; }

    @JsonIgnore
    public JsonNode getECRRScores() { return ECRRScores; }

    @JsonIgnore
    public JsonNode getVIAScores() { return VIAScores; }

    @JsonIgnore
    public JsonNode getSDTScores() { return SDTScores; }

    @JsonIgnore
    public Float getSecureBaseScore() { return SecureBaseScore; }
}
