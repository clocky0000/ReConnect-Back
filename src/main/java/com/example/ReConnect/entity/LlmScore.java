package com.example.ReConnect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "llm_scores",
        indexes = {
                @Index(name = "idx_session_partner", columnList = "session_id,partner"),
                @Index(name = "idx_item", columnList = "item_id")
        })
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class LlmScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id", nullable = false, length = 64)
    private String sessionId;           // 예: sess-001

    @Column(nullable = false, length = 1)
    private String partner;             // "A" or "B"

    @Column(name = "item_id", nullable = false)
    private Integer itemId;             // 1..36

    @Column(nullable = false)
    private Double pred;                // 1..7 예측값

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;   // 저장 시각
}
