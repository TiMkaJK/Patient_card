package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.DiagnosisDto;
import com.pristavka.patient_card.mapper.DiagnosisMapper;
import com.pristavka.patient_card.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/diagnoses")
public class DiagnosisRestController {

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @PostMapping(path = "/")
    public DiagnosisDto addDiagnosis(@RequestBody String name) {
        return this.diagnosisMapper.toDto(this.diagnosisService.save(name));
    }
}

