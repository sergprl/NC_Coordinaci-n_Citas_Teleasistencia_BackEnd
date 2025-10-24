package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {

    Appointment save(Appointment appointment);

    List<Appointment> findAll();

    Optional<Appointment> findById(Long id);
}
