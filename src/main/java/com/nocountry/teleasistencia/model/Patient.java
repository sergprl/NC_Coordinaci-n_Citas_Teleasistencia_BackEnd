package com.nocountry.teleasistencia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@PrimaryKeyJoinColumn(name = "user_id")
public class Patient extends User{

    private LocalDate birthDate;

    private String address;

    private String genre;
}
