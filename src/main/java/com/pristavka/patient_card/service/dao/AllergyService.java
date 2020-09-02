package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.model.Allergy;

import java.util.List;

public interface AllergyService
{
    com.pristavka.patient_card.model.Allergy save(com.pristavka.patient_card.model.Allergy allergy);

    List<com.pristavka.patient_card.model.Allergy> findAll();

    void deleteById(long id);
}

