package com.nocountry.teleasistencia.dto.response;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Specialty;

import java.time.LocalDateTime;

public record ResponseAppointmentDto(
        Long Id,
        Long patientId,
        Long doctorId,
        LocalDateTime appointmentDate,
        Integer lengthMinutes,
        AppointmentType appointmentType,
        String link,
        AppointmentStatus appointmentStatus,
        Specialty specialty,
        String reason
) {

}
