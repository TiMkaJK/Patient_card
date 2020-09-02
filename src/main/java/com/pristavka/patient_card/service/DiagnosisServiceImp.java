package com.pristavka.patient_card.service;

import com.pristavka.patient_card.repo.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisServiceImp implements com.pristavka.patient_card.service.dao.DiagnosisService
{
    @Autowired
    private DiagnosisRepository diagnosisRepository;

    @Override
    public com.pristavka.patient_card.model.Diagnosis save(com.pristavka.patient_card.model.Diagnosis diagnosis)
    {
        return diagnosisRepository.save(diagnosis);
    }

    @Override
    public List<com.pristavka.patient_card.model.Diagnosis> findAll()
    {
        return diagnosisRepository.findAll();
    }

    @Override
    public void deleteById(long id)
    {
        diagnosisRepository.deleteById(id);
    }

}

