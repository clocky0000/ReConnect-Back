package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record ScoreItemDto(
        @JsonProperty("item_id")
        @NotNull @Min(1) @Max(100) Integer itemId,

        @JsonProperty("pred")
        @NotNull @DecimalMin("1.0") @DecimalMax("7.0") Double pred
) {}
