package com.nocountry.teleasistencia.model;

import com.nocountry.teleasistencia.model.enums.Specialty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Doctor extends User{

    @Enumerated(EnumType.STRING)
    private Specialty specialty;

    @Column(unique = true)
    private String licenseNumber;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments= new ArrayList<>();

}
