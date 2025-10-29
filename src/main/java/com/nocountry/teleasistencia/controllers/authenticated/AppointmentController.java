package com.nocountry.teleasistencia.controllers.authenticated;

import com.nocountry.teleasistencia.services.impl.GoogleMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.nocountry.teleasistencia.common.ApiPaths.APPOINTMENT_BASE;

@RestController
@RequestMapping(APPOINTMENT_BASE)
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AppointmentController {
    private final GoogleMeetService meetService;

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

}
