package com.pristavka.patient_card.service.jpa.impl;

import com.pristavka.patient_card.mapper.PatientMapper;
import com.pristavka.patient_card.model.jpa.Patient;
import com.pristavka.patient_card.repository.jpa.PatientRepository;
import com.pristavka.patient_card.service.jpa.PatientService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatient(Long id) throws NotFoundException {
        return this.patientRepository.findById(id).orElseThrow(() -> new NotFoundException("Patient not found"));
    }

    @Override
    public Page<Patient> getPatients(Pageable pageable) {
        return this.patientRepository.findAll(pageable);
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
    public Patient update(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public void delete(Long id) {
        this.patientRepository.deleteById(id);
    }
}

