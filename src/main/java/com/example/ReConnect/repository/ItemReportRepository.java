package com.example.ReConnect.repository;

import com.example.ReConnect.entity.ItemReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

@Repository
public interface ItemReportRepository extends JpaRepository<ItemReport, Long> {

    Optional<ItemReport> findByCoupleCodeAndItemId(String coupleCode, Integer itemId);

    @Query("select coalesce(max(r.itemId), 0) from ItemReport r where r.coupleCode = :code")
    int findLastReportItemId(@Param("code") String coupleCode);
}

