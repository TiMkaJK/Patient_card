package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.mapper.PatientMapper;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.PatientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/patients")
@Tag(name = "Patient", description = "Provide manipulation with patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @GetMapping(path = "/list")
    public List<Patient> findAllPatients() {
        return this.patientService.findAll();
    }

    @PostMapping(path = "/save")
    public Patient savePatient(@RequestBody PatientDto patientDto) {
        return this.patientService.save(this.patientMapper.toModel(patientDto));
    }

    @GetMapping(path = "/{id}")
    public Patient findPatientById(@PathVariable Long id) {
        return this.patientService.findById(id);
    }
}

