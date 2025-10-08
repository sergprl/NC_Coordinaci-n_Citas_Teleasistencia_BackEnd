package com.nocountry.teleasistencia.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserDTO {
    private Long id;
    private String email;
    private String role;
}
