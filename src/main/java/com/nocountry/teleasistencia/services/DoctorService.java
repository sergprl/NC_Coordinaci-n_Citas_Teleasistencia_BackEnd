package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.dto.request.RequestDoctorDto;
import com.nocountry.teleasistencia.dto.response.ResponseDoctorDto;
import com.nocountry.teleasistencia.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorService {

    Doctor save(RequestDoctorDto dto);

    List<ResponseDoctorDto> findAll();

    ResponseDoctorDto findById(Long id);
}
