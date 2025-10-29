package com.nocountry.teleasistencia.controllers.authenticated;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.dto.response.ResponsePatientDto;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.services.AppointmentService;
import com.nocountry.teleasistencia.services.PatientService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<ResponsePatientDto>> getAllPatients() {
        List<ResponsePatientDto> patients = patientService.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePatientDto> getPatientById(@PathVariable Long id) {
        ResponsePatientDto patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping("/appointment")
    public ResponseEntity<Boolean> createAppointment(@RequestBody RequestAppointmentDto appointmentDto) {
        appointmentService.createAppointment(appointmentDto);
        return ResponseEntity.ok(true);
    }
}
