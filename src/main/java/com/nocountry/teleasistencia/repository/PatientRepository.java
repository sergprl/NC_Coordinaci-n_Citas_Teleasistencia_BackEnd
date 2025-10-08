package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Patient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PatientRepository extends CrudRepository<Patient, Long> {

    Patient save(Patient patient);

    List<Patient> findAll();

    Optional<Patient> findById(long id);
}
