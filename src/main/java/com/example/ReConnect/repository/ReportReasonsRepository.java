package com.example.ReConnect.repository;


import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportReasons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportReasonsRepository extends JpaRepository<ReportReasons, Integer> {
    Optional<ReportReasons> findByDiary(Diary diary);
}
