package com.example.ReConnect.repository;

import com.example.ReConnect.entity.LlmScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LlmScoreRepository extends JpaRepository<LlmScore, Long> {
    List<LlmScore> findBySessionIdAndPartnerOrderByCreatedAtAsc(String sessionId, String partner);
}
