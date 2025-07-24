package com.example.ReConnect.repository;

import com.example.ReConnect.entity.ReportText;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReportTextRepository extends JpaRepository<ReportText, Long> {
    Optional<ReportText> findByUserIdAndDate(String userId, LocalDate date);
}
