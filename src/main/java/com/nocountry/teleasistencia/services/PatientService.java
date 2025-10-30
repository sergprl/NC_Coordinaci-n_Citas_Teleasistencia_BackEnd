package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.dto.request.RequestPatientDto;
import com.nocountry.teleasistencia.dto.response.ResponsePatientDto;
import com.nocountry.teleasistencia.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientService {

    ResponsePatientDto save(RequestPatientDto dto);

    List<ResponsePatientDto> findAll();

    ResponsePatientDto findById(Long id);

}