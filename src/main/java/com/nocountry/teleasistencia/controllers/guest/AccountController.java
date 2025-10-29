package com.nocountry.teleasistencia.controllers.guest;

import com.nocountry.teleasistencia.dto.request.RequestDoctorDto;
import com.nocountry.teleasistencia.dto.request.RequestPatientDto;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.services.DoctorService;
import com.nocountry.teleasistencia.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.nocountry.teleasistencia.common.ApiPaths.PUBLIC_BASE;

@RestController
@RequiredArgsConstructor
@RequestMapping(PUBLIC_BASE + "/account")
public class AccountController {
    private final DoctorService doctorService;
    private final PatientService patientService;

    @PostMapping("/register/doctor")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody RequestDoctorDto doctor) {
        Doctor savedDoctor = doctorService.save(doctor);
        return ResponseEntity.status(201).body(savedDoctor);
    }

    @PostMapping("/register/patient")
    public ResponseEntity<Patient> savePatient(@RequestBody RequestPatientDto patient) {
        Patient savedPatient = patientService.save(patient);
        return ResponseEntity.status(201).body(savedPatient);
    }
}
