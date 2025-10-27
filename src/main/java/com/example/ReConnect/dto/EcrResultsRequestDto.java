package com.example.ReConnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import java.util.List;

public record EcrResultsRequestDto(
        @NotNull Meta meta,
        @NotEmpty List<Answer> answers
) {
    public record Meta(
            @JsonProperty("schema_version") @NotBlank String schemaVersion,
            @JsonProperty("created_at")    @NotBlank String createdAt,
            @JsonProperty("couple_id")     @NotBlank String coupleId
    ) {}

    public record Answer(
            @JsonProperty("item_id")   @Positive int itemId,
            @NotBlank String dimension,                 // "anxiety" | "avoidance"
            @PositiveOrZero double score,               // blend
            @NotBlank String text,
            @JsonProperty("is_reverse") boolean isReverse,
            @JsonProperty("partner_id") @Pattern(regexp="A|B") String partnerId
    ) {}
}
