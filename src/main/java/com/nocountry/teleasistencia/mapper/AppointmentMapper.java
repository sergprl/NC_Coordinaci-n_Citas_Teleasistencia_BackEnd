package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.dto.response.ResponseAppointmentDto;
import com.nocountry.teleasistencia.exceptions.DoctorNotFoundException;
import com.nocountry.teleasistencia.exceptions.PatientNotFoundException;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.repository.DoctorRepository;
import com.nocountry.teleasistencia.repository.PatientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {DoctorMapper.class, PatientMapper.class})
public abstract class AppointmentMapper {
    @Autowired
    protected PatientRepository patientRepository;

    @Autowired
    protected DoctorRepository doctorRepository;

    @Mapping(source = "patientId", target = "patient")
    @Mapping(source = "doctorEmail", target = "doctor")
    public abstract Appointment toEntity(RequestAppointmentDto dto);

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(source = "doctor.id", target = "doctorId")
    public abstract ResponseAppointmentDto toResponse(Appointment appointment);

    protected Patient mapPatient(Long patientId) {
        if (patientId == null) return null;

        return patientRepository
                .findById(patientId)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with id: " + patientId));
    }

    protected Doctor mapDoctor(String doctorEmail) {
        if (doctorEmail == null) return null;

        return doctorRepository
                .findByEmail(doctorEmail)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with email: " + doctorEmail));
    }

}
