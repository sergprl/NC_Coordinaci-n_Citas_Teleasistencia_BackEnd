package com.nocountry.teleasistencia.controllers.authenticated;

import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.nocountry.teleasistencia.common.ApiPaths.DOCTOR_BASE;

@RestController
@RequestMapping(DOCTOR_BASE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<?> getAllDoctors() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDoctorDto> getDoctorById(@PathVariable Long id) {
        ResponseDoctorDto doctor = doctorService.findById(id);
        return ResponseEntity.ok(doctor);
    }

}
