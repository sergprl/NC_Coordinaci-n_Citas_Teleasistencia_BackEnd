package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);
}
