package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.Appointment;

import java.time.LocalDate;
import java.util.List;

public record ResponsePatientDto(
        LocalDate birthDate,
        String address,
        List<Appointment> appointments
) {
}
