package com.pristavka.patient_card.service.jpa.impl;

import com.pristavka.patient_card.model.jpa.PatientDrug;
import com.pristavka.patient_card.repository.jpa.PatientDrugRepository;
import com.pristavka.patient_card.service.jpa.PatientDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientDrugServiceImpl implements PatientDrugService {

    @Autowired
    private PatientDrugRepository patientDrugRepository;

    @Override
    public void save(PatientDrug patientDrug) {
        this.patientDrugRepository.save(patientDrug);
    }
}

