package com.nocountry.teleasistencia.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDTO {
    @NotBlank
    private String  email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    private String phone;
    @NotBlank
    private String role;

    // Doctor specific fields
    private String specialty;
    private String licenseNumber;

    // Patient specific fields
    private String birthDate;
    private String address;
    private String genre;

}
