package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.enums.Specialty;

import java.util.List;

public record ResponseDoctorDto(
        Long id,
        String email,
        String name,
        String lastName,
        String phone,
        String gender,
        Specialty specialty,
        String licenseNumber,
        List<Long> appointments
) {
}
