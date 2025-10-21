package com.nocountry.teleasistencia.mapper;


import com.nocountry.teleasistencia.dto.request.RequestPatientDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponsePatientDto;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AppointmentMapper.class})
public interface PatientMapper {
    @Mapping(target = "birthDate", source = "dto.birthDate")
    @Mapping(target = "address", source = "dto.address")
    Patient toEntity(RequestPatientDto dto);

    ResponsePatientDto toResponse(Patient patient);
}
