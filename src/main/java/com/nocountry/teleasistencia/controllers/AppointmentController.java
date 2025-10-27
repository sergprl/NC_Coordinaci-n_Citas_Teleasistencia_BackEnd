package com.nocountry.teleasistencia.controllers;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.services.AppointmentService;
import com.nocountry.teleasistencia.services.impl.GoogleMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

import static com.nocountry.teleasistencia.common.ApiPaths.APPOINTMENT_BASE;
import static com.nocountry.teleasistencia.common.ApiPaths.PATIENT_BASE;

@RestController
@RequestMapping(APPOINTMENT_BASE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {
    private final GoogleMeetService meetService;
    private final AppointmentService appointmentService;


    @GetMapping("/create")
    public ResponseEntity<String> createMeeting() {
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        String meetLink = meetService.createMeetingLink(
                "Customer Meeting",
                startTime,
                30
        );

        return ResponseEntity.ok(meetLink);
    }
    @PostMapping
    public ResponseEntity<?> createAppointment(@RequestBody RequestAppointmentDto dto) {
        boolean created = appointmentService.createAppointment(dto);

        if (created) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("✅ Cita creada exitosamente y correo enviado al paciente.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("⚠️ No se pudo crear la cita. Verifique los datos o el horario.");
        }
    }
}


