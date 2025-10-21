package com.nocountry.teleasistencia.model;

import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Specialty;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Clase de la capa de entidades que define todos los datos relacionados con una
 * cita médica en la base de datos de la aplicación Spring.
 * <>
 */

@Entity
@Table(name = "citas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @NotNull
    @FutureOrPresent
    @Column(name = "appointmentDate", nullable = false)
    private LocalDateTime appointmentDate;

    @NotNull
    @Column(name = "lengthMinutes", nullable = false)
    private Integer lengthMinutes;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointmentType", nullable = false)
    private AppointmentType appointmentType;

    private String link;

    @Enumerated(EnumType.STRING)
    @Column(name = "appointmentStatus", nullable = false)
    private AppointmentStatus appointmentStatus;

    @NotNull(message = "El área de tratamiento (especialidad) es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(name = "specialty", nullable = false)
    private Specialty specialty;

    @Column(length = 255)
    private String reason;
}
