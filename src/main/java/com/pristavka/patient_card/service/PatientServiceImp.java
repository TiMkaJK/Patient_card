package com.pristavka.patient_card.service;

import com.pristavka.patient_card.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImp implements com.pristavka.patient_card.service.dao.PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public com.pristavka.patient_card.model.Patient findById(long id)
    {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public List<com.pristavka.patient_card.model.Patient> findAll()
    {
        return patientRepository.findAll();
    }

    @Override
    public com.pristavka.patient_card.model.Patient save(com.pristavka.patient_card.model.Patient patient)
    {
        return patientRepository.save(patient);
    }


}

