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
        return this.patientRepository.findById(id).orElseThrow(() -> new NotFoundException("patient not found"));
    }

    @Override
    public List<Patient> findAllPatients()
    {
        return this.patientRepository.findAllPatients();
    }

    @Override
    public Patient save(Patient patient)
    {
        return this.patientRepository.save(patient);
    }

    @Override
    public List<Patient> findAllByUserId(int id)
    {
        return this.patientRepository.findAllByUserId(id);
    }
}

