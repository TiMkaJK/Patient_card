package com.pristavka.patient_card.service;

import com.pristavka.patient_card.model.mongo.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DrugService {

    Page<Drug> getDrugs(Pageable pageable);

    void saveDrugs();
}
