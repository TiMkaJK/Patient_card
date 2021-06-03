package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/patients")
@Tag(name = "Patient", description = "Provide manipulation with patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "list")
    public List<Patient> findAllPatients() {
        return this.patientService.findAll();
    }

    @PostMapping(path = "/save")
    public Patient addPatient(@RequestBody Patient patient) {
        return this.patientService.save(patient);
    }

    @GetMapping(path = "/{id}")
    public Patient findPatientById(@PathVariable Long id) {
        return this.patientService.findById(id);
    }
}

