package com.nocountry.teleasistencia.mapper;

import com.nocountry.teleasistencia.dto.request.UserRequestDto;
import com.nocountry.teleasistencia.dto.response.UserResponseDto;
import com.nocountry.teleasistencia.model.User;
import com.nocountry.teleasistencia.model.enums.Gender;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "created_at", expression = "java(java.time.LocalDate.now())")
    User toEntity(UserRequestDto dto);

    UserResponseDto toResponse(User user);

}

