package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.repo.DiagnosisRepository;
import com.pristavka.patient_card.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImpl implements DiagnosisService
{
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public Diagnosis save(Diagnosis diagnosis)
    {
        return this.diagnosisRepository.save(diagnosis);
    }

    @Override
    public List<Diagnosis> findAll()
    {
        return this.diagnosisRepository.findAll();
    }

    @Override
    public void deleteById(long id)
    {
        this.diagnosisRepository.deleteById(id);
    }
}

