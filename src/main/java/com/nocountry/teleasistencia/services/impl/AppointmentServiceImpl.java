package com.nocountry.teleasistencia.services.impl;

import com.nocountry.teleasistencia.dto.request.RequestAppointmentDto;
import com.nocountry.teleasistencia.exceptions.DoctorNotFoundException;
import com.nocountry.teleasistencia.exceptions.PatientNotFoundException;
import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.model.Doctor;
import com.nocountry.teleasistencia.model.Patient;
import com.nocountry.teleasistencia.model.enums.AppointmentStatus;
import com.nocountry.teleasistencia.model.enums.AppointmentType;
import com.nocountry.teleasistencia.model.enums.Gender;
import com.nocountry.teleasistencia.repository.AppointmentRepository;
import com.nocountry.teleasistencia.repository.DoctorRepository;
import com.nocountry.teleasistencia.repository.PatientRepository;
import com.nocountry.teleasistencia.repository.UserRepository;
import com.nocountry.teleasistencia.security.SecurityUtils;
import com.nocountry.teleasistencia.services.AppointmentService;
import com.nocountry.teleasistencia.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final PatientRepository patientRepository;
    private final GoogleMeetService meetService;
    private final AppointmentRepository appointmentRepository;
    private final EmailService emailService;


    @Override
    public Appointment save(Appointment appointment) {
        return null;
    }

    @Override
    public List<Appointment> findAll() {
        return List.of();
    }

    @Override
    public Optional<Appointment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean createAppointment(RequestAppointmentDto dto) {
        if (!doctorRepository.existsByEmail(dto.doctorEmail())) return false;
        Doctor doctor = doctorRepository.findByEmail(dto.doctorEmail())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with email: " + dto.doctorEmail()));

        List<Appointment> appointments = doctor.getAppointments();

        for (Appointment other : appointments) {
            if(dto.appointmentDate().equals(other.getAppointmentDate())) return false;
        }

        String patientEmail = dto.patientEmail();
        Patient patient = patientRepository.findByEmail(patientEmail)
                .orElseThrow(() -> new PatientNotFoundException("Patient not found with email: " + patientEmail));


        String meetLink;

        if (dto.appointmentType() == AppointmentType.VIRTUAL) {
            meetLink = meetService.createMeetingLink(
                    String.format("Cita de 1 hora con %s %s %s.",
                            doctor.getGender() == Gender.MASCULINO ? "el Dr." : "la Dra.",
                            doctor.getName(),
                            doctor.getLastName()),
                    dto.appointmentDate(),
                    dto.lengthMinutes()
            );
        } else {
            meetLink = "La cita es presencial";
        }

        Appointment appointment = Appointment.builder()
                .patient(patient)
                .doctor(doctor)
                .appointmentDate(dto.appointmentDate())
                .lengthMinutes(dto.lengthMinutes())
                .appointmentType(dto.appointmentType())
                .link(meetLink)
                .appointmentStatus(AppointmentStatus.PROGRAMADA)
                .specialty(dto.specialty())
                .reason(dto.reason())
                .build();

        doctor.getAppointments().add(appointment);
        patient.getAppointments().add(appointment);

        appointmentRepository.save(appointment);



// ✅ Enviar correo de confirmación al paciente
        emailService.enviarConfirmacionCita(appointment);
        return true;
    }


}
