package com.example.ReConnect.repository;


import com.example.ReConnect.entity.Diary;
import com.example.ReConnect.entity.ReportMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportMetadataRepository extends JpaRepository<ReportMetadata, Integer> {
    Optional<ReportMetadata> findByDiary(Diary diary);
}
