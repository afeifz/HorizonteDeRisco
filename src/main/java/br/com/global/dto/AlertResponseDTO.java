package br.com.global.dto;

import lombok.Builder;

@Builder
public record AlertResponseDTO(
        Long id,
        String message,
        String riskLevel
) {
}