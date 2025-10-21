package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.enums.Gender;
import com.nocountry.teleasistencia.model.enums.Role;

import java.time.LocalDate;

public record UserResponseDto(
        Long id,
        String name,
        String lastName,
        String phone,
        String email,
        Role role,
        Gender gender,
        LocalDate created_at
        ) {
}
