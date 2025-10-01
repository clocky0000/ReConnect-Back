package com.example.ReConnect.controller;

import com.example.ReConnect.service.AdviceService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advice")
public class AdviceController {

    private final AdviceService adviceService;
    public AdviceController(AdviceService adviceService) {
        this.adviceService = adviceService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAdvice() {
        return ResponseEntity.ok(adviceService.getAdviceAll(1L));
    }

    @GetMapping("/advice/{itemId}")
    public ResponseEntity<?> getAdviceByItemId(@PathVariable int itemId) {
        try {
            JsonNode advice = adviceService.getAdviceByItemId(itemId);
            if (advice == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(advice);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("에러 발생: " + e.getMessage());
        }
    }

    @GetMapping("/advice_feature/{itemId}")
    public ResponseEntity<?> getAdviceFeatureByItemId(@PathVariable int itemId) {
        try {
            JsonNode advice = adviceService.getAdviceFeatureByItemId(itemId);
            if (advice == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(advice);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("에러 발생: " + e.getMessage());
        }
    }

    @GetMapping("/advice_sim/{itemId}")
    public ResponseEntity<?> getAdviceSimByItemId(@PathVariable int itemId) {
        try {
            JsonNode advice = adviceService.getAdviceSimByItemId(itemId);
            if (advice == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(advice);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("에러 발생: " + e.getMessage());
        }
    }
}
