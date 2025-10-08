package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

    Doctor save(Doctor doctor);

    List<Doctor> findAll();

    Optional<Doctor> findById(long id);
}