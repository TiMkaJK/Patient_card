package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    Diagnosis save(Diagnosis diagnosis);

    List<Diagnosis> getDiagnoses();

    void delete(Long id);

    Diagnosis update(Diagnosis diagnosis);

    Diagnosis getDiagnosis(Long id);
}
