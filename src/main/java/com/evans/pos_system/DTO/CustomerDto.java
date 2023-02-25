package com.evans.pos_system.DTO;

public record CustomerDto(
        Long id,
        String username,
        String email,
        String phoneNumber
) {
}
