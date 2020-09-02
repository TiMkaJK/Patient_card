package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.model.Diagnosis;

import java.util.List;

public interface DiagnosisService
{
    com.pristavka.patient_card.model.Diagnosis save(com.pristavka.patient_card.model.Diagnosis diagnosis);

    List<com.pristavka.patient_card.model.Diagnosis> findAll();

    void deleteById(long id);
}
