package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    boolean existsByEmail(String email);
    Optional<Patient> findByEmail(String email);
}
