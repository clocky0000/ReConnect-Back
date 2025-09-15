package com.example.ReConnect.repository;

import com.example.ReConnect.entity.FinalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FinalReportRepository extends JpaRepository<FinalReport, Long> {
    Optional<FinalReport> findByCoupleCode(String coupleId);
}
