package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    Diagnosis save(Diagnosis diagnosis);

    List<Diagnosis> findAll();

    void deleteById(long id);
}
