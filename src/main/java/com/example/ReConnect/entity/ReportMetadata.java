package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Entity
@Table(name = "report_metadata")
public class ReportMetadata {

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
    @JsonProperty("PHQ_8_meta")
    private JsonNode PHQ8Meta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("GAD_7_meta")
    private JsonNode GAD7Meta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("BAI_meta")
    private JsonNode BAIMeta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("ECR_R_meta")
    private JsonNode ECRRMeta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("VIA_meta")
    private JsonNode VIAMeta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("SDT_meta")
    private JsonNode SDTMeta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("Psychoanalytic_meta")
    private JsonNode PsychoanalyticMeta;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("SecureBase_meta")
    private JsonNode SecureBaseMeta;

    public ReportMetadata() {}

    // Getters
    public Long getId() { return id; }
    public String getUserId() { return userId; }
    public LocalDate getDate() { return date; }

    @JsonIgnore
    public Diary getDiary() { return diary; }

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

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setDate(LocalDate date) { this.date = date; }
    public void setDiary(Diary diary) { this.diary = diary; }
    public void setPHQ8Meta(JsonNode PHQ8Meta) { this.PHQ8Meta = PHQ8Meta; }
    public void setGAD7Meta(JsonNode GAD7Meta) { this.GAD7Meta = GAD7Meta; }
    public void setBAIMeta(JsonNode BAIMeta) { this.BAIMeta = BAIMeta; }
    public void setECRRMeta(JsonNode ECRRMeta) { this.ECRRMeta = ECRRMeta; }
    public void setVIAMeta(JsonNode VIAMeta) { this.VIAMeta = VIAMeta; }
    public void setSDTMeta(JsonNode SDTMeta) { this.SDTMeta = SDTMeta; }
    public void setPsychoanalyticMeta(JsonNode PsychoanalyticMeta) { this.PsychoanalyticMeta = PsychoanalyticMeta; }
    public void setSecureBaseMeta(JsonNode SecureBaseMeta) { this.SecureBaseMeta = SecureBaseMeta; }
}
