package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    Patient save(Patient patient);

    List<Patient> findAll();

    Optional<Patient> findById(Long id);


}