package com.nocountry.teleasistencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User{

    private String specialty;

    @Column(unique = true)
    private String licenseNumber;


}
