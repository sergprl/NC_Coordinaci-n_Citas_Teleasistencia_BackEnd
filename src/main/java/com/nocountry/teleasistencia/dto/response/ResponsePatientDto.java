package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public record ResponsePatientDto(
        Long id,
        String email,
        String name,
        String lastName,
        String phone,
        String gender,
        LocalDate birthDate,
        String address,
        List<Long> appointments
) {
}
