package com.example.ReConnect.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "advice")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private String advice;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("advice_feature")
    private String adviceFeature;

    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    @JsonProperty("advice_sim")
    private String adviceSim;

    public Advice() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAdvice() { return advice; }
    public void setAdvice(String advice) { this.advice = advice; }

    public String getAdviceFeature() { return adviceFeature; }
    public void setAdviceFeature(String adviceFeature) { this.adviceFeature = adviceFeature; }

    public String getAdviceSim() { return adviceSim; }
    public void setAdviceSim(String adviceSim) { this.adviceSim = adviceSim; }
}
