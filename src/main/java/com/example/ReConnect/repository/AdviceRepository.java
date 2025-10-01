package com.example.ReConnect.repository;

import com.example.ReConnect.entity.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {

    @Query(value = """
        SELECT elem
        FROM advice,
        LATERAL jsonb_array_elements(advice.advice) elem
        WHERE CAST(elem->>'item_id' AS int) = :itemId
        """, nativeQuery = true)
    String findAdviceByItemId(@Param("itemId") int itemId);

    @Query(value = """
        SELECT elem
        FROM advice,
        LATERAL jsonb_array_elements(advice_feature) elem
        WHERE CAST(elem->>'item_id' AS int) = :itemId
        """, nativeQuery = true)
    String findAdviceFeatureByItemId(@Param("itemId") int itemId);

    @Query(value = """
       SELECT elem
       FROM advice,
       LATERAL jsonb_array_elements(advice_sim) elem
       WHERE CAST(elem->>'item_id_a' AS int) = :itemId
       """, nativeQuery = true)
    String findAdviceSimByItemId(@Param("itemId") int itemId);
}
