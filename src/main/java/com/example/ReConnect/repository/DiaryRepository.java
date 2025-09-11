package com.example.ReConnect.repository;

import com.example.ReConnect.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByUserIdAndCoupleCodeAndQuestionNumber(String userId, String coupleCode, Integer questionNumber);
}
