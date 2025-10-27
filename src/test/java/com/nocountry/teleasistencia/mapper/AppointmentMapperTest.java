package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Specialty;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class AppointmentMapperTest {
    private final AppointmentMapper appointmentMapper;

    @Test
    void shouldMapDtoToEntity() {
        RequestAppointmentDto dto = new RequestAppointmentDto(
                101L,
                201L,
                LocalDateTime.of(2025,5,5,12,0),
                60,
                AppointmentType.VIRTUAL,
                AppointmentStatus.PROGRAMADA,
                Specialty.PSIQUIATRIA,
                "Analizar resultados de pruebas"
        );


        Appointment entity = appointmentMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(AppointmentType.VIRTUAL, entity.getAppointmentType());

    }
}
