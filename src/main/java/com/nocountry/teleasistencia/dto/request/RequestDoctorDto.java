package com.nocountry.teleasistencia.dto.request;

import com.nocountry.teleasistencia.model.enums.Specialty;

public record RequestDoctorDto(
        Specialty specialty,
        String licenseNumber
) {
}
