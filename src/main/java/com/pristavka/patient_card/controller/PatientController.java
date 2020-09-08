package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientServiceImp patientService;

    @GetMapping("/")
    public List<Patient> findAllPatients()
    {
        return this.patientService.findAll();
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient)
    {
        return this.patientService.save(patient);
    }

    @GetMapping("/patient/{id}")
    public Patient findPatientById(@PathVariable long id)
    {
        return this.patientService.findById(id);
    }
}

