package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Entity
@Table(name = "report_scores")
public class ReportScores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private LocalDate date;

    // 연결된 일기
    @OneToOne
    @JoinColumn(name = "diary_id", referencedColumnName = "id", nullable = false, unique = true)
    private Diary diary;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("PHQ_8_scores")
    private JsonNode PHQ8Scores;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("GAD_7_scores")
    private JsonNode GAD7Scores;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("BAI_scores")
    private JsonNode BAIScores;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("ECR_R_scores")
    private JsonNode ECRRScores;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("VIA_scores")
    private JsonNode VIAScores;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("SDT_scores")
    private JsonNode SDTScores;

    @Column(name = "SecureBase_score")
    private Float SecureBaseScore;

    public ReportScores() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    @JsonIgnore
    public Diary getDiary() { return diary; }
    public void setDiary(Diary diary) { this.diary = diary; }

    @JsonIgnore
    public JsonNode getPHQ8Scores() { return PHQ8Scores; }
    public void setPHQ8Scores(JsonNode PHQ8Scores) { this.PHQ8Scores = PHQ8Scores; }

    @JsonIgnore
    public JsonNode getGAD7Scores() { return GAD7Scores; }
    public void setGAD7Scores(JsonNode GAD7Scores) { this.GAD7Scores = GAD7Scores; }

    @JsonIgnore
    public JsonNode getBAIScores() { return BAIScores; }
    public void setBAIScores(JsonNode BAIScores) { this.BAIScores = BAIScores; }

    @JsonIgnore
    public JsonNode getECRRScores() { return ECRRScores; }
    public void setECRRScores(JsonNode ECRRScores) { this.ECRRScores = ECRRScores; }

    @JsonIgnore
    public JsonNode getVIAScores() { return VIAScores; }
    public void setVIAScores(JsonNode VIAScores) { this.VIAScores = VIAScores; }

    @JsonIgnore
    public JsonNode getSDTScores() { return SDTScores; }
    public void setSDTScores(JsonNode SDTScores) { this.SDTScores = SDTScores; }

    @JsonIgnore
    public Float getSecureBaseScore() { return SecureBaseScore; }
    public void setSecureBaseScore(Float secureBaseScore) { this.SecureBaseScore = secureBaseScore; }
}