package com.example.ReConnect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ecr_items")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EcrItem {
    @Id
    @Column(name = "item_id")
    private Integer itemId; // 1..36

    @Column(nullable = false, length = 512)
    private String text;

    @Column(name = "reverse_scored", nullable = false)
    private boolean reverseScored;
}
