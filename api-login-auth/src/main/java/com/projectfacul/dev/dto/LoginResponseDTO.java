package com.projectfacul.dev.dto;

public record LoginResponseDTO(
        String token,
        Long id,
        String name
) {
}
