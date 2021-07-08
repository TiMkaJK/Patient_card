package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Diagnosis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiagnosisService {

    Diagnosis save(Diagnosis diagnosis);

    Page<Diagnosis> getDiagnoses(Pageable pageable);

    void delete(Long id);

    Diagnosis update(Diagnosis diagnosis);

    Diagnosis getDiagnosis(Long id);
}
