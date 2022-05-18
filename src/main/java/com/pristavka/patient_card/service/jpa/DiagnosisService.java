package com.pristavka.patient_card.service.jpa;


import com.pristavka.patient_card.model.jpa.Diagnosis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webjars.NotFoundException;

public interface DiagnosisService {

    Diagnosis save(Diagnosis diagnosis);

    Page<Diagnosis> getDiagnoses(Pageable pageable);

    void delete(Long id);

    Diagnosis update(Diagnosis diagnosis);

    Diagnosis getDiagnosis(Long id) throws NotFoundException;
}
