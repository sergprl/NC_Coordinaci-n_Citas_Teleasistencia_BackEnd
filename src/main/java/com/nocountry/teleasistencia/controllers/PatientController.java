package com.nocountry.teleasistencia.controllers;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.security.SecurityUtils;
import com.nocountry.teleasistencia.services.AppointmentService;
import com.nocountry.teleasistencia.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.nocountry.teleasistencia.common.ApiPaths.PATIENT_BASE;

@RestController
@RequestMapping(PATIENT_BASE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PatientController {

    private final PatientService patientService;
    private final AppointmentService appointmentService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Optional<Patient> patient = patientService.findById(id);
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) {
        Patient savedPatient = patientService.save(patient);
        return ResponseEntity.status(201).body(savedPatient);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Boolean> createAppointment(@RequestBody RequestAppointmentDto appointmentDto) {
        appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.ok(true);
    }
}
