package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.dto.response.ResponseAppointmentDto;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public interface AppointmentMapper {

    @Mapping(source = "patientId", target = "patient")
    @Mapping(source = "doctorId", target = "doctor")
    Appointment toEntity(RequestAppointmentDto dto);

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.id", target = "doctorId")
    ResponseAppointmentDto toResponse(Appointment appointment);

    default Patient mapPatient(Long patientId) {
        if (patientId == null) return null;
        Patient p = new Patient();
        p.setId(patientId);
        return p;
    }

    default Doctor mapDoctor(Long doctorId) {
        if (doctorId == null) return null;
        Doctor d = new Doctor();
        d.setId(doctorId);
        return d;
    }

}
