package com.nocountry.teleasistencia.services.impl;


import com.nocountry.teleasistencia.model.Appointment;
import com.nocountry.teleasistencia.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.format.DateTimeFormatter;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    // 🔹 Constructor manual para inyección de dependencias
    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    @Override
    public void enviarConfirmacionCita(Appointment cita) {
        try {

            Context context = new Context();
            context.setVariable("nombre", cita.getPatient().getName());
            context.setVariable("fecha", cita.getAppointmentDate().toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            context.setVariable("hora", cita.getAppointmentDate().toLocalTime().format(DateTimeFormatter.ofPattern("hh:mm a"))); // formato 12h
            context.setVariable("motivo", cita.getReason());

            // 🔹 Solo si la cita es virtual, se agrega el link
            if (cita.getAppointmentType() != null && cita.getAppointmentType().name().equals("VIRTUAL")) {
                context.setVariable("linkReunion", cita.getLink());
            } else {
                context.setVariable("linkReunion", null);
            }
            String htmlContent = templateEngine.process("email-cita", context);

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(cita.getPatient().getEmail());
            helper.setSubject("Confirmación de cita médica");
            helper.setFrom("jedatoos@gmail.com");
            helper.setText(htmlContent, true);

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Error enviando correo", e);
        }
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true); // CORREGIDO
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true); // CORREGIDO
            helper.setFrom("jedatoos@gmail.com");

            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Error enviando correo", e);
        }
    }

    @Override
    public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setFrom("jedatoos@gmail.com");
        helper.setText(htmlContent, true);

        mailSender.send(message);
    }
}

