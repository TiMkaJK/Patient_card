package com.pristavka.patient_card.service.dao;

import com.pristavka.patient_card.model.Allergy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AllergyService
{
    Allergy save(Allergy allergy);

    List<Allergy> findAll();

    List<Allergy> findAllByGroup(String group);

    Page<Allergy> findAll(Pageable pageable);
}

