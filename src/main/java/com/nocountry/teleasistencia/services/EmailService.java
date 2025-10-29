package com.nocountry.teleasistencia.services;


import com.nocountry.teleasistencia.model.Appointment;
import jakarta.mail.MessagingException;

public interface EmailService {
    void enviarConfirmacionCita(Appointment appointment);

    void sendEmail(String to, String subject, String text);

    void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException;

}
