package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.repository.DoctorRepository;
import com.nocountry.teleasistencia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final UserService userService;

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(UserService userService, DoctorRepository doctorRepository) {
        this.userService = userService;
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        userService.save(doctor, "DOCTOR");
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
