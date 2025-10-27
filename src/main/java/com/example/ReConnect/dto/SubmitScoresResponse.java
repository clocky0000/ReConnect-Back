package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SubmitScoresResponse(
        String status,
        @JsonProperty("session_id") String sessionId,
        @JsonProperty("partner") String partner,
        int received
) {}
