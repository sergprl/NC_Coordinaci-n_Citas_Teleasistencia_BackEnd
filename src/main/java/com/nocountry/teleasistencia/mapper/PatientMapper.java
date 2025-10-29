package com.nocountry.teleasistencia.mapper;


import com.nocountry.teleasistencia.dto.request.RequestPatientDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponsePatientDto;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AppointmentMapper.class})
public interface PatientMapper {
    @Mapping(target = "birthDate", source = "dto.birthDate")
    @Mapping(target = "address", source = "dto.address")
    @Mapping(target = "created_at", expression = "java(java.time.LocalDate.now())")
    Patient toEntity(RequestPatientDto dto);

    @Mapping(target = "appointments", source = "appointments")
    ResponsePatientDto toResponse(Patient patient);

    default List<Long> mapAppointmentsToIds(List<Appointment> appointments) {
        if (appointments == null) return null;
        return appointments.stream()
                .map(Appointment::getId)
                .toList();
    }
}
