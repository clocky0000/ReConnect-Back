package com.example.ReConnect.controller;

import com.example.ReConnect.dto.ItemReportDto;
import com.example.ReConnect.service.ItemReportService;
import com.example.ReConnect.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/itemReport")
public class ItemReportController {

    private final UserService userService;
    private final ItemReportService itemReportService;

    public ItemReportController(UserService userService, ItemReportService itemReportService) {
        this.userService = userService;
        this.itemReportService = itemReportService;
    }

    @PostMapping("/submit")
    public ResponseEntity<?> submitItemReport(@RequestBody ItemReportDto dto, HttpSession session)  {
        String userId = (String) session.getAttribute("loginId");
        if (userId == null) {
            return ResponseEntity.status(401).body("로그인이 필요합니다.");
        }

        String coupleCode = userService.findById(userId).getCoupleCode();
        Integer itemId = dto.getItemId();

        try {
            itemReportService.saveItemReport(dto, coupleCode, itemId);
            return ResponseEntity.ok("제출 완료");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            return ResponseEntity.status(500).body("서버 에러");
        }
    }

    @GetMapping("/{coupleCode}/{itemId}")
    public ResponseEntity<?> getItemReport(@PathVariable String coupleCode,
                                           @PathVariable Integer itemId) {
        ItemReportDto dto = itemReportService.getItemReport(coupleCode, itemId);
        if (dto == null) {
            return ResponseEntity.badRequest().body("아이템 리포트가 생성되지 않았습니다.");
        }

        return ResponseEntity.ok(dto);
    }
}
