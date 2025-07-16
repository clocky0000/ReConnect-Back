package com.example.ReConnect.repository;

import com.example.ReConnect.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report, String> {
    Optional<Report> findByUserIdAndDate(String userId, LocalDate date);
}
