package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.service.DiagnosisServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiagnosisController
{
    @Autowired
    private DiagnosisServiceImp diagnosisServiceImp;

    @PostMapping("/addDiagnosis")
    public Diagnosis addDiagnosis(@RequestBody String name)
    {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(name);
        return this.diagnosisServiceImp.save(diagnosis);
    }
}

