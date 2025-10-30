package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.dto.request.RequestDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.exceptions.DoctorNotFoundException;
import com.nocountry.teleasistencia.mapper.DoctorMapper;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.enums.Role;
import com.nocountry.teleasistencia.repository.DoctorRepository;
import com.nocountry.teleasistencia.services.DoctorService;
import com.nocountry.teleasistencia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;
    private final PasswordEncoder encoder;

    @Override
    public ResponseDoctorDto save(RequestDoctorDto dto) {
        if (doctorRepository.existsByLicenseNumber(dto.licenseNumber())) {
            throw new IllegalArgumentException("Doctor with license number already exists.");
        }
        if (doctorRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email already in use.");
        }

        Doctor doctor = doctorMapper.toEntity(dto);

        doctor.setRole(Role.DOCTOR);
        doctor.setPassword(encoder.encode(doctor.getPassword()));

        return doctorMapper.toResponse(doctorRepository.save(doctor));
    }

    @Override
    public List<ResponseDoctorDto> findAll() {
        return doctorRepository.findAll()
                .stream()
                .map(doctorMapper::toResponse)
                .toList();
    }

    @Override
    public ResponseDoctorDto findById(Long id) {
        return doctorMapper.toResponse(doctorRepository.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id)));
    }
}
