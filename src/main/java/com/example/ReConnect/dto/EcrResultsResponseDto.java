package com.example.ReConnect.dto;

public record EcrResultsResponseDto(
        String status,
        String coupleId,
        String sessionId,
        int saved
) {}
