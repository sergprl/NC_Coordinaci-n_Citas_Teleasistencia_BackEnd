package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.enums.Role;
import com.nocountry.teleasistencia.repository.DoctorRepository;
import com.nocountry.teleasistencia.services.DoctorService;
import com.nocountry.teleasistencia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor save(Doctor doctor) {
        if (doctorRepository.existsByLicenseNumber(doctor.getLicenseNumber())) {
            throw new IllegalArgumentException("Doctor with license number already exists.");
        }
        if (doctorRepository.existsByEmail(doctor.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        doctor.setRole(Role.DOCTOR);

        // TODO: Encrypt the password

        return doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Optional<Doctor> findById(Long id) {
        return doctorRepository.findById(id);
    }
}
