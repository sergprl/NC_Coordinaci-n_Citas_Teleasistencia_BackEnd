package com.nocountry.teleasistencia.controllers;

import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Optional<Doctor> doctor = doctorService.findById(id);
        return doctor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor) {
        Doctor savedDoctor = doctorService.save(doctor);
        return ResponseEntity.status(201).body(savedDoctor);
    }
}
