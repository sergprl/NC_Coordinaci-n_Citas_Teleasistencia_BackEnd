package com.nocountry.teleasistencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TeleasistenciaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeleasistenciaBackendApplication.class, args);
    }

}
