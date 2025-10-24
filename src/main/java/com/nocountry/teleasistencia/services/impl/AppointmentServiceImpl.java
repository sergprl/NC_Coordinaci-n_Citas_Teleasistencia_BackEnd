package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.services.AppointmentService;

import java.util.List;
import java.util.Optional;

public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public Appointment save(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return Optional.empty();
    }
}
