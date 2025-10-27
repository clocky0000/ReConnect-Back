package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.util.List;

public record SubmitScoresRequest(
        @NotBlank
        @Pattern(regexp = "A|B") String partner,

        @JsonProperty("session_id")
        @NotBlank String sessionId,

        @Size(min = 1) List<ScoreItemDto> scores
) {}
