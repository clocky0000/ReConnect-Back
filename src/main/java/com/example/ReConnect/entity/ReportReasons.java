package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.time.LocalDate;

@Entity
@Table(name = "report_reasons")
public class ReportReasons {

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
    @JsonProperty("key_emotions")
    private JsonNode KeyEmotions;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("core_keywords")
    private JsonNode CoreKeywords;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("PHQ_8_reasons")
    private JsonNode PHQ8Reasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("GAD_7_reasons")
    private JsonNode GAD7Reasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("BAI_reasons")
    private JsonNode BAIReasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("ECR_R_reasons")
    private JsonNode ECRReasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("VIA_reasons")
    private JsonNode VIAReasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("SDT_reasons")
    private JsonNode SDTReasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("DefenseMechanism_reasons")
    private JsonNode DefenseMechanismReasons;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("SecureBase_reasons")
    private JsonNode SecureBaseReasons;

    public ReportReasons() {}

    // Getter and Setter
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
    public JsonNode getKeyEmotions() { return KeyEmotions; }
    public void setKeyEmotions(JsonNode keyEmotions) { this.KeyEmotions = keyEmotions; }

    @JsonIgnore
    public JsonNode getCoreKeywords() { return CoreKeywords; }
    public void setCoreKeywords(JsonNode coreKeywords) { this.CoreKeywords = coreKeywords; }

    @JsonIgnore
    public JsonNode getPHQ8Reasons() { return PHQ8Reasons; }
    public void setPHQ8Reasons(JsonNode PHQ8Reasons) { this.PHQ8Reasons = PHQ8Reasons; }

    @JsonIgnore
    public JsonNode getGAD7Reasons() { return GAD7Reasons; }
    public void setGAD7Reasons(JsonNode GAD7Reasons) { this.GAD7Reasons = GAD7Reasons; }

    @JsonIgnore
    public JsonNode getBAIReasons() { return BAIReasons; }
    public void setBAIReasons(JsonNode BAIReasons) { this.BAIReasons = BAIReasons; }

    @JsonIgnore
    public JsonNode getECRReasons() { return ECRReasons; }
    public void setECRReasons(JsonNode ECRReasons) { this.ECRReasons = ECRReasons; }

    @JsonIgnore
    public JsonNode getVIAReasons() { return VIAReasons; }
    public void setVIAReasons(JsonNode VIAReasons) { this.VIAReasons = VIAReasons; }

    @JsonIgnore
    public JsonNode getSDTReasons() { return SDTReasons; }
    public void setSDTReasons(JsonNode SDTReasons) { this.SDTReasons = SDTReasons; }

    @JsonIgnore
    public JsonNode getDefenseMechanismReasons() { return DefenseMechanismReasons; }
    public void setDefenseMechanismReasons(JsonNode DefenseMechanismReasons) { this.DefenseMechanismReasons = DefenseMechanismReasons; }

    @JsonIgnore
    public JsonNode getSecureBaseReasons() { return SecureBaseReasons; }
    public void setSecureBaseReasons(JsonNode SecureBaseReasons) { this.SecureBaseReasons = SecureBaseReasons; }
}
