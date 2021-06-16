package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.mapper.PatientMapper;
import com.pristavka.patient_card.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @GetMapping(path = "/")
    public List<PatientDto> getPatients() {
        return this.patientMapper.toDtoList(this.patientService.findAll());
    }

    @PostMapping(path = "/")
    public PatientDto savePatient(@RequestBody PatientDto patientDto) {
        return this.patientMapper.toDto(this.patientService.save(this.patientMapper.toModel(patientDto)));
    }

    @GetMapping(path = "/{id}")
    public PatientDto getPatientById(@PathVariable @Min(1) Long id) {
        return this.patientMapper.toDto(this.patientService.findById(id));
    }
}

