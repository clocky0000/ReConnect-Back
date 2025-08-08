package com.example.ReConnect.repository;


import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportScores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportScoresRepository extends JpaRepository<ReportScores, Long> {
    Optional<ReportScores> findByDiary(Diary diary);
}
