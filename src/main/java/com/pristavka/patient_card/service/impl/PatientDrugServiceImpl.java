package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.PatientDrug;
import com.pristavka.patient_card.repository.PatientDrugRepository;
import com.pristavka.patient_card.service.PatientDrugService;
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

