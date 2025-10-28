package com.example.ReConnect.repository;

import com.example.ReConnect.entity.Diary;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {
    Optional<Diary> findByUserIdAndCoupleCodeAndQuestionNumber(String userId, String coupleCode, Integer questionNumber);

    List<Diary> findByCoupleCodeAndQuestionNumber(String coupleCode, Integer questionNumber);

    @Query("""
            select d.questionNumber
            from Diary d
            where d.coupleCode = :code
            group by d.questionNumber
            having count(d) >= 2
            order by d.questionNumber desc
            """)
    List<Integer> findCompletedQuestionNumbers(@Param("code") String coupleCode, Pageable pageable);

    long countByUserId(String userId);
}
