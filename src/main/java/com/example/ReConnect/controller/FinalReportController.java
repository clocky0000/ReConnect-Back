package com.example.ReConnect.controller;

import com.example.ReConnect.dto.FinalReportDto;
import com.example.ReConnect.service.FinalReportService;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finalReport")
public class FinalReportController {
    private final UserService userService;
    private final FinalReportService finalReportService;

    public FinalReportController(UserService userService, FinalReportService finalReportService) {
        this.userService = userService;
        this.finalReportService = finalReportService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitFinalReport(@RequestBody FinalReportDto dto, HttpSession session) {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        String coupleCode = userService.findById(userId).getCoupleCode();

        try {
            finalReportService.saveFinalReport(dto, coupleCode);
            return ResponseEntity.ok("제출 완료");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("서버 에러");
        }
    }

    @GetMapping("/{coupleCode}")
    public ResponseEntity<?> getFinalReport(@PathVariable String coupleCode) {
        FinalReportDto dto = finalReportService.getFinalReport(coupleCode);
        if (dto == null) {
            return ResponseEntity.badRequest().body("아직 파이널 리포트가 생성되지 않았습니다.");
        }

        return ResponseEntity.ok(dto);
    }
}
