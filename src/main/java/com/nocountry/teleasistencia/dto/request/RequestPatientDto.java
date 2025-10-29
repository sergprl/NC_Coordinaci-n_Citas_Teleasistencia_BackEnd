package com.nocountry.teleasistencia.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record RequestPatientDto(
        Long id,
        String email,
        String password,
        String name,
        String lastName,
        String phone,
        String gender,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate birthDate,
        String address
) {
}
