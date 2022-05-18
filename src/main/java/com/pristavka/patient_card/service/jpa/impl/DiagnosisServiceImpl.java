package com.pristavka.patient_card.service.jpa.impl;

import com.pristavka.patient_card.model.jpa.Diagnosis;
import com.pristavka.patient_card.repository.jpa.DiagnosisRepository;
import com.pristavka.patient_card.service.jpa.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis save(Diagnosis diagnosis) {
        return this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public Page<Diagnosis> getDiagnoses(Pageable pageable) {
        return this.diagnosisRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        this.diagnosisRepository.deleteById(id);
    }

    @Override
    public Diagnosis update(Diagnosis diagnosis) {
        return this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public Diagnosis getDiagnosis(Long id) throws NotFoundException {
        return this.diagnosisRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No such diagnosis found"));
    }
}

