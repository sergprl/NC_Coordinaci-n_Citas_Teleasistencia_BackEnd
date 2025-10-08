package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor save(Doctor doctor);

    List<Doctor> findAll();

    Optional<Doctor> findById(Long id);
}
