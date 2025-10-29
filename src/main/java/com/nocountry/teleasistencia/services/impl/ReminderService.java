package com.nocountry.teleasistencia.services.impl;


import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.repository.AppointmentRepository;
import com.nocountry.teleasistencia.services.EmailService;
import jakarta.mail.MessagingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
public class ReminderService {

    private final AppointmentRepository citaRepository;
    private final SpringTemplateEngine templateEngine;
    private final EmailService emailService;

    public ReminderService(AppointmentRepository citaRepository, SpringTemplateEngine templateEngine, EmailService emailService) {
        this.citaRepository = citaRepository;
        this.templateEngine = templateEngine;
        this.emailService = emailService;
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void enviarRecordatorios() {
        log.info("⏰ Ejecutando recordatorios a las {}", LocalDateTime.now());
        LocalDate hoy = LocalDate.now();
        LocalDateTime startOfDay = hoy.atStartOfDay();
        LocalDateTime endOfDay = hoy.atTime(LocalTime.MAX);

        List<Appointment> citas = citaRepository.findCitasDeHoyNoNotificadas(startOfDay, endOfDay);

        if (citas.isEmpty()) {
            log.info("📭 No hay citas pendientes de recordatorio.");
            return;
        }

        for (Appointment cita : citas) {
            try {
                // Redondea segundos y nanos
                LocalTime ahora = LocalTime.now().withSecond(0).withNano(0);
                LocalTime horaCita = cita.getAppointmentDate().toLocalTime().withSecond(0).withNano(0);

                long minutosRestantes = Duration.between(ahora, horaCita).toMinutes();
                log.info("Minutos restantes para cita de {}: {}",
                        cita.getPatient().getEmail(),
                        minutosRestantes);

                // Solo para el mismo día y exactamente 1 minuto antes
                if (cita.getAppointmentDate().toLocalDate().equals(hoy) && minutosRestantes == 1) {
                    log.info("Link de reunión para {} → {}", cita.getPatient().getEmail()
                            , cita.getLink());

                    Context context = new Context();
                    context.setVariable("nombre", cita.getPatient().getName());
                    context.setVariable("fecha", cita.getAppointmentDate().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    context.setVariable("hora", cita.getAppointmentDate().toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"))); // formato 12h
                    context.setVariable("motivo", cita.getReason());

                    // 🔹 Incluir el mismo link de la cita virtual (si existe)
                    if (cita.getAppointmentType() != null && cita.getAppointmentType().name().equals("VIRTUAL")) {
                        context.setVariable("linkReunion", cita.getLink());
                    } else {
                        context.setVariable("linkReunion", null);
                    }

                    String htmlContent = templateEngine.process("email-recordatorio", context);
                    String asunto = "📅 Recordatorio de cita médica";

                    emailService.sendHtmlEmail(cita.getPatient().getEmail()
                            , asunto, htmlContent);
                    log.info("✅ Recordatorio enviado a {}", cita.getPatient().getEmail()
                    );

                    cita.setRecordatorioEnviado(true);
                    citaRepository.save(cita);
                }
            } catch (MessagingException e) {
                log.error("❌ Error enviando recordatorio a {}: {}", cita.getPatient().getEmail()
                        , e.getMessage(), e);
            } catch (Exception e) {
                log.error("⚠️ Error general procesando cita {}: {}", cita.getId(), e.getMessage(), e);
            }
        }

        log.info("🏁 Proceso de recordatorios finalizado. Total enviados: {}", citas.size());
    }
}