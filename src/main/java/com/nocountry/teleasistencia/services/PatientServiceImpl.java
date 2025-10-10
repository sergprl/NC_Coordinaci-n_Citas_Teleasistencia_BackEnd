package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    private final UserService userService;

    public PatientServiceImpl(PatientRepository patientRepository, UserService userService) {
        this.patientRepository = patientRepository;
        this.userService = userService;
    }


    @Override
    public Patient save(Patient patient) {
        userService.save(patient, "PATIENT");
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findById(Long id) {
        return patientRepository.findById(id);
    }
}
