package com.nocountry.teleasistencia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Clase heredada de RuntimeException que se encargará de controlar y lanzar un aviso
 * al manejador de excepciones en caso de no encontrar al paciente deseado en el sistema.
 * <>
 */
@ResponseStatus(HttpStatus.NO_CONTENT)
public class PatientNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 3L
            ;
    public PatientNotFoundException(String mensaje) {
        super(mensaje);
    }
}
