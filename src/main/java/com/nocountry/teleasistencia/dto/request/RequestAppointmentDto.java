package com.nocountry.teleasistencia.dto.request;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Specialty;

import java.time.LocalDateTime;

public record RequestAppointmentDto(
        Long patientId,
        Long doctorId,
        LocalDateTime appointmentDate,
        Integer lengthMinutes,
        AppointmentType appointmentType,
        AppointmentStatus appointmentStatus,
        Specialty specialty,
        String reason
) {

}
