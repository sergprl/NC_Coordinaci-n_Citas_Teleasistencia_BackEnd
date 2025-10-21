package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.dto.response.ResponseAppointmentDto;
import com.nocountry.teleasistencia.model.Appointment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface AppointmentMapper {
    Appointment toEntity(RequestAppointmentDto dto);

    ResponseAppointmentDto toResponse(Appointment appointment);

}
