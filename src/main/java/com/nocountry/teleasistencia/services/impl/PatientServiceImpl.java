package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.dto.request.RequestPatientDto;
import com.nocountry.teleasistencia.dto.response.ResponsePatientDto;
import com.nocountry.teleasistencia.exceptions.PatientNotFoundException;
import com.nocountry.teleasistencia.mapper.PatientMapper;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.Role;
import com.nocountry.teleasistencia.repository.PatientRepository;
import com.nocountry.teleasistencia.services.PatientService;
import com.nocountry.teleasistencia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;
    private final PasswordEncoder encoder;

    @Override
    public ResponsePatientDto save(RequestPatientDto dto) {
        if (patientRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        Patient patient = patientMapper.toEntity(dto);

        patient.setRole(Role.PATIENT);
        patient.setPassword(encoder.encode(patient.getPassword()));

        return patientMapper.toResponse(patientRepository.save(patient));
    }

    @Override
    public List<ResponsePatientDto> findAll() {
        return patientRepository.findAll()
                .stream()
                .map(patientMapper::toResponse)
                .toList();
    }

    @Override
    public ResponsePatientDto findById(Long id) {
        return patientMapper.toResponse(patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: "
                 + id)));
    }
}
