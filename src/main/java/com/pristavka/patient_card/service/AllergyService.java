package com.pristavka.patient_card.service;

import com.pristavka.patient_card.model.Allergy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AllergyService {

    Allergy save(Allergy allergy);

    Allergy update(Allergy allergy);

    Allergy getAllergy(Long id);

    List<Allergy> findAllByGroup(String group);

    Page<Allergy> getAllergies(Pageable pageable);

    void delete(Long id);
}

