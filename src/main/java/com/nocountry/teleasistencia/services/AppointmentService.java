package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import org.springframework.security.core.parameters.P;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> findAll();

    Optional<Appointment> findById(Long id);

    Boolean createAppointment(RequestAppointmentDto dto);
}
