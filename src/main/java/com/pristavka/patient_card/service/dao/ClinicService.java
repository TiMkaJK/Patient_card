package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.model.Clinic;

import java.util.List;

public interface ClinicService
{
    com.pristavka.patient_card.model.Clinic save(com.pristavka.patient_card.model.Clinic clinic);

    List<com.pristavka.patient_card.model.Clinic> findAll();

    void deleteById(long id);
}
