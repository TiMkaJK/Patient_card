package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.model.Patient;

import java.util.List;

public interface PatientService
{
    com.pristavka.patient_card.model.Patient findById(long id);

    List<com.pristavka.patient_card.model.Patient> findAll();

    com.pristavka.patient_card.model.Patient save(com.pristavka.patient_card.model.Patient patient);
}
