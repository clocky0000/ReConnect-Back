package com.example.ReConnect.repository;

import com.example.ReConnect.entity.ItemReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemReportRepository extends JpaRepository<ItemReport, Long> {
    Optional<ItemReport> findByCoupleCodeAndItemId(String coupleCode, Integer itemId);
}
