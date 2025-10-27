package com.nocountry.teleasistencia.repository;

import com.nocountry.teleasistencia.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a " +
            "WHERE a.appointmentDate >= :startOfDay " +
            "AND a.appointmentDate < :endOfDay " +
            "AND a.recordatorioEnviado = false")
    List<Appointment> findCitasDeHoyNoNotificadas(
            @Param("startOfDay") LocalDateTime startOfDay,
            @Param("endOfDay") LocalDateTime endOfDay);
   boolean existsByAppointmentDate(LocalDateTime appointmentDate);
}
