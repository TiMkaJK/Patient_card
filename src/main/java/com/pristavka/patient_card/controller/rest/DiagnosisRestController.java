package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.service.DiagnosisService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/diagnoses")
@Tag(name = "Diagnosis", description = "Provide manipulation with diagnosis")
public class DiagnosisRestController {

    @Autowired
    private DiagnosisService diagnosisService;

    @Operation(summary = "Add a new diagnosis")
    @PostMapping("/save")
    public Diagnosis addDiagnosis(@RequestBody String name) {

        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(name);
        return this.diagnosisService.save(diagnosis);
    }
}

