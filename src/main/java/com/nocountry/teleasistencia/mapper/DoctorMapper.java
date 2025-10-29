package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AppointmentMapper.class})
public interface DoctorMapper {

    @Mapping(target = "specialty", source = "dto.specialty")
    @Mapping(target = "licenseNumber", source = "dto.licenseNumber")
    @Mapping(target = "created_at", expression = "java(java.time.LocalDate.now())")
    Doctor toEntity(RequestDoctorDto dto);

    @Mapping(target = "appointments", source = "appointments")
    ResponseDoctorDto toResponse(Doctor doctor);

    default List<Long> mapAppointmentsToIds(List<Appointment> appointments) {
        if (appointments == null) return null;
        return appointments.stream()
                .map(Appointment::getId)
                .toList();
    }
}
