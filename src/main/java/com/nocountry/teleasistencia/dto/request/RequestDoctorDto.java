package com.nocountry.teleasistencia.dto.request;

import com.nocountry.teleasistencia.model.enums.Specialty;

public record RequestDoctorDto(
        Long id,
        String email,
        String password,
        String name,
        String lastName,
        String phone,
        String gender,
        Specialty specialty,
        String licenseNumber
) {
}
