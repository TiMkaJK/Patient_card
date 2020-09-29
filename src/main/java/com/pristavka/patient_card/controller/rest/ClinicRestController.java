package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.service.ClinicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(ClinicRestController.CLINIC_URL)
@Tag(name = "Clinic", description = "Provide manipulation with clinics")
public class ClinicRestController
{
    public static final String CLINIC_URL = "/clinics";

    @Autowired
    private ClinicService clinicService;

    @Operation(summary = "Add a new clinic")
    @PostMapping("/save")
    public Clinic saveClinic(@RequestBody String name)
    {
        Clinic clinic = new Clinic();
        clinic.setName(name);
        return this.clinicService.save(clinic);
    }
}
