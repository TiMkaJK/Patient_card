package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.mapper.PatientMapper;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.repository.PatientRepository;
import com.pristavka.patient_card.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMapper patientMapper;

    @Override
    public Patient findById(Long id) {
        return this.patientRepository.findById(id).orElseThrow(() -> new NotFoundException("patient not found"));
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public List<Patient> findAllByUserEmail(String email) {
        return this.patientRepository.findAllByUserEmail(email);
    }

    @Override
    public Patient save(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public Patient findPatientById(Long id) {
        return this.patientRepository.findPatientById(id);
    }
}

