package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.repo.PatientRepository;
import com.pristavka.patient_card.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService
{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findById(long id)
    {
        return patientRepository.findById(id).orElseThrow(() -> new NotFoundException("patient not found"));
    }

    @Override
    public List<Patient> findAll()
    {
        return patientRepository.findAll();
    }

    @Override
    public Patient save(Patient patient)
    {
        return patientRepository.save(patient);
    }


}

