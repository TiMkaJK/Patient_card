package com.pristavka.patient_card.component;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:patient.properties")
@Getter
public class PatientProperties
{
    @Value("${admin.value}")
    private String admin;

    @Value("${user.value}")
    private String user;

    @Value("${admin.request}")
    private String adminRequest;

    @Value("${patients.value}")
    private String patients;
}

