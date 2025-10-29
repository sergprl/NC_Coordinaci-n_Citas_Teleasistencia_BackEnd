package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.exceptions.PatientNotFoundException;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Specialty;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class AppointmentMapperTest {
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Test
    void toEntity_shouldThrowException_whenPatientNotFound() {
        RequestAppointmentDto dto = new RequestAppointmentDto(
                "doctor@example.com",   // ahora es String
                "patient@example.com",  // ahora es String
                LocalDateTime.of(2025,5,5,12,0),
                60,
                AppointmentType.VIRTUAL,
                AppointmentStatus.PROGRAMADA,
                Specialty.PSIQUIATRIA,
                "Analizar resultados de pruebas"
        );


        PatientNotFoundException exception = assertThrows(
                PatientNotFoundException.class,
                () -> appointmentMapper.toEntity(dto)
        );

        assertEquals("Patient not found with id: 101", exception.getMessage());

    }
}
