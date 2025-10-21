package com.nocountry.teleasistencia.dto.request;

import com.nocountry.teleasistencia.model.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public record UserRequestDto(
        @NotBlank String email,
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String password,
        String phone,
        Gender gender
        ) {}
