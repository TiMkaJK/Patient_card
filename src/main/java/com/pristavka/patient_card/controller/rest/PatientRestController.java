package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.impl.PatientServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PatientRestController.PATIENTS_URL)
@Tag(name = "Patient", description = "Provide manipulation with patients")
public class PatientRestController
{
    public static final String PATIENTS_URL = "/patients";
    @Autowired
    private PatientServiceImpl patientService;

    @GetMapping()
    public List<Patient> findAllPatients()
    {
        return this.patientService.findAll();
    }

    @PostMapping("/save")
    public Patient addPatient(@RequestBody Patient patient)
    {
        return this.patientService.save(patient);
    }

    @GetMapping("/{id}")
    public Patient findPatientById(@PathVariable long id)
    {
        return this.patientService.findById(id);
    }
}

