package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.enums.Specialty;

import java.util.List;

public record ResponseDoctorDto(
        Specialty specialty,
        String licenseNumber,
        List<Appointment> appointments
) {
}
