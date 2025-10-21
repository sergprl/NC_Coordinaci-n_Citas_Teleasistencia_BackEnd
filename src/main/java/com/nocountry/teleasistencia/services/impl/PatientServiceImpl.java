package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.Role;
import com.nocountry.teleasistencia.repository.PatientRepository;
import com.nocountry.teleasistencia.services.PatientService;
import com.nocountry.teleasistencia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        if (patientRepository.existsByEmail(patient.getEmail())) {
            throw new IllegalArgumentException("Email already in use.");
        }
        patient.setRole(Role.PATIENT);

        // TODO: Encrypt password

        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}
