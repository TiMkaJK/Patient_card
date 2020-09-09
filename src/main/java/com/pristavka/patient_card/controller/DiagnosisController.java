package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.service.DiagnosisServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DiagnosisController.DIAGNOSIS_URL)
public class DiagnosisController
{
    public static final String DIAGNOSIS_URL = "/diagnoses";

    @Autowired
    private DiagnosisServiceImp diagnosisServiceImp;

    @PostMapping("/save")
    public Diagnosis addDiagnosis(@RequestBody String name)
    {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(name);
        return this.diagnosisServiceImp.save(diagnosis);
    }
}

