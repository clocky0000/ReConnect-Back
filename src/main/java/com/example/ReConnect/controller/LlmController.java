package com.example.ReConnect.controller;

import com.example.ReConnect.dto.*;
import com.example.ReConnect.entity.LlmScore;
import com.example.ReConnect.repository.EcrItemRepository;
import com.example.ReConnect.repository.LlmScoreRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/llm")
@RequiredArgsConstructor
public class LlmController {

    private final LlmScoreRepository scoreRepo;
    private final EcrItemRepository itemRepo;

    // 헬스 체크
    @GetMapping("/test")
    public Map<String, Object> test() {
        return Map.of(
                "app", "ReConnect-Back",
                "status", "OK",
                "time", OffsetDateTime.now().toString()
        );
    }

    /** LLM → 백엔드 점수 제출 */
    @PostMapping("/scores")
    public SubmitScoresResponse receiveScores(@RequestBody @Valid SubmitScoresRequest req) {
        var now = OffsetDateTime.now();
        req.scores().forEach(s -> {
            var entity = LlmScore.builder()
                    .sessionId(req.sessionId())
                    .partner(req.partner())
                    .itemId(s.itemId())
                    .pred(s.pred())
                    .createdAt(now)
                    .build();
            scoreRepo.save(entity);
        });
        return new SubmitScoresResponse("ok", req.sessionId(), req.partner(), req.scores().size());
    }

    /** 백엔드 → 문항 목록 반환 */
    @GetMapping("/items")
    public Map<String, Object> getItems() {
        return Map.of(
                "version", "ECR-R.v1",
                "items", itemRepo.findAll().stream().map(i -> Map.of(
                        "item_id", i.getItemId(),
                        "text", i.getText()
                )).toList()
        );
    }

    /** ✅ 통합 결과 업로드 (IR/FR/시계열 기반) */
    @PostMapping("/ecr-results")
    public EcrResultsResponseDto receiveEcrResults(
            @RequestParam("coupleId") String coupleId,
            @RequestParam(value = "sessionId", required = false) String sessionId,
            @RequestBody @Valid EcrResultsRequestDto req
    ) {
        if (!coupleId.equals(req.meta().coupleId())) {
            throw new IllegalArgumentException("coupleId mismatch between query param and payload.meta.couple_id");
        }
        // TODO: 영속화 로직(answers 저장). 현재는 저장 건수만 반환.
        int saved = req.answers().size();
        return new EcrResultsResponseDto("ok", coupleId, sessionId, saved);
    }
}
