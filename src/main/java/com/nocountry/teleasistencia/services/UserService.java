package com.nocountry.teleasistencia.services;

import com.nocountry.teleasistencia.dto.request.UserRequestDto;
import com.nocountry.teleasistencia.dto.response.UserResponseDto;
import com.nocountry.teleasistencia.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findById(Long id);

    UserResponseDto save(UserRequestDto user);

    boolean existsUsername(String username);
}
