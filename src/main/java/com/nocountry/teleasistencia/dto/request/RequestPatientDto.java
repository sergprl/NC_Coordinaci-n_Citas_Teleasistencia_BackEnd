package com.nocountry.teleasistencia.dto.request;

import java.time.LocalDate;

public record RequestPatientDto(
        LocalDate birthDate,
        String address
) {
}
