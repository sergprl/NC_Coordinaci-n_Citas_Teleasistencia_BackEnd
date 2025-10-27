# NC_Coordinaci-n_Citas_Teleasistencia_BackEnd
No Country - Portal Web de Coordinación de Citas y Teleasistencia

## Descripcion del proyecto
Backend en Spring Boot para gestionar la programación y seguimiento de citas médicas en línea. Permite la interacción entre pacientes y doctores, controla la disponibilidad de los profesionales, genera enlaces de videollamadas para las consultas, y gestiona la seguridad mediante roles diferenciados.

Tecnologías principales: Spring Boot 3, H2, JPA/Hibernate, Spring Security, Lombok.

## Consideraciones
Se hace uso de una base de datos H2.

## Usuarios y seguridad
El código base cuenta con los siguientes 3 usuarios:
* Admin: admin@gmail.com, contraseña: password
* Patient: patient@gmail.com, contraseña: password
* Doctor: doctor@gmail.com, contraseña: password

Ejemplo
<img width="1184" height="480" alt="image" src="https://github.com/user-attachments/assets/7f1ae5ab-3e52-4ba5-bfab-d168877cd78b" />

Únicamente el paciente cuenta con permisos para crear una cita.
* Endpoint (POST): http://localhost:8080/api/v1/patient/appointment
* Se hacen revisiones de la disponibilidad del doctor, después de eso, la cita sea aceptada automáticamente
* Si la cita es VIRTUAL, se crea un link de GoogleMeet
* Ejemplo de mensaje JSON para crear la cita
{
    "doctorEmail" : "doctor@gmail.com",
    "appointmentDate" : "2025-12-31T10:00:00",
    "lengthMinutes" : 60,
    "appointmentType" : "VIRTUAL",
    "appointmentStatus" : "PROGRAMADA",
    "specialty" : "PSIQUIATRIA",
    "reason" : "revisar resutlados de pruebas"

}

## Google Meet
Para que la creación de citas virtuales funcione, es necesario crear credenciales del tipo "Service Accounts" in Google Cloud, con permisos para Google Meet y Google Calendar. Las credenciales deben ser guardadas en el directorio "\src\main\resources" con los nombres "credentials.json" y "service-account-key.json". Si, después de añadir las credenciales, el programa no funciona correctamente, es necesario borrar el directorio "tokens" que se encuentra en el directorio base del programa.
