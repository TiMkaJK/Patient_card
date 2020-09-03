package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.Allergy;

import java.util.List;

public interface AllergyService
{
    Allergy save(Allergy allergy);

    List<Allergy> findAll();

    void deleteById(long id);
}

