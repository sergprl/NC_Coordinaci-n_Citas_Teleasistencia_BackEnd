package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    boolean existsByLicenseNumber(String licenseNumber);
    boolean existsByEmail(String email);
    Optional<Doctor> findByEmail(String email);

}