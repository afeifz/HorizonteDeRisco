package br.com.global.dto;

import lombok.Builder;

@Builder
public record EventResponseDTO(
        Long id,
        String title,
        String category,
        String riskLevel
) {
}