package com.example.ReConnect.repository;

import com.example.ReConnect.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Survey, Long> {
    Optional<Survey> findByUserIdAndCoupleCode(String userId, String coupleCode);
}