package com.pristavka.patient_card;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableAsync
//@EnableScheduling
@EnableJpaRepositories(basePackages = {"com.pristavka.patient_card.repository.jpa"})
@SpringBootApplication
public class PatientCardApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientCardApplication.class, args);
    }
}