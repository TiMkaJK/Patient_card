package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.repository.DiagnosisRepository;
import com.pristavka.patient_card.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis save(Diagnosis diagnosis) {
        return this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public List<Diagnosis> getDiagnoses() {
        return this.diagnosisRepository.findAll();
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
    public Diagnosis getDiagnosis(Long id) {
        return this.diagnosisRepository.getById(id);
    }
}

