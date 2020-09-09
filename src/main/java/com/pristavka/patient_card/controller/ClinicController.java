package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.repo.ClinicRepository;
import com.pristavka.patient_card.service.ClinicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClinicController.CLINIC_URL)
public class ClinicController
{
    public static final String CLINIC_URL = "/clinics";

    @Autowired
    private ClinicServiceImp clinicServiceImp;

    @PostMapping("/save")
    public Clinic addClinic(@RequestBody String name)
    {
        Clinic clinic = new Clinic();
        clinic.setName(name);
        return this.clinicServiceImp.save(clinic);
    }
}

