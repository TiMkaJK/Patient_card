package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.service.ClinicServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClinicController
{
    @Autowired
    private ClinicServiceImp clinicServiceImp;

    @PostMapping("/addClinic")
    public Clinic addClinic(@RequestBody String name)
    {
        Clinic clinic = new Clinic();
        clinic.setName(name);
        return this.clinicServiceImp.save(clinic);
    }
}

