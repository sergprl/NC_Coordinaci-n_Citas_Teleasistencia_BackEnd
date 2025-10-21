package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AppointmentMapper.class})
public interface DoctorMapper {

    @Mapping(target = "specialty", source = "dto.specialty")
    @Mapping(target = "licenseNumber", source = "dto.licenseNumber")
    Doctor toEntity(RequestDoctorDto dto);

    ResponseDoctorDto toResponse(Doctor doctor);
}
