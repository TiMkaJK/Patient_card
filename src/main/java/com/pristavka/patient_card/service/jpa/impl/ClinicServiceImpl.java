package com.pristavka.patient_card.service.jpa.impl;

import com.pristavka.patient_card.model.jpa.Clinic;
import com.pristavka.patient_card.repository.jpa.ClinicRepository;
import com.pristavka.patient_card.service.jpa.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic save(Clinic clinic) {
        return this.clinicRepository.save(clinic);
    }

    @Override
    public Clinic update(Clinic clinic) {
        return this.clinicRepository.save(clinic);
    }

    @Override
    public Page<Clinic> getClinics(Pageable pageable) {
        return this.clinicRepository.findAll(pageable);
    }

    @Override
    public Clinic getClinic(Long id) {
        return this.clinicRepository.getById(id);
    }

    @Override
    public void delete(Long id) {
        this.clinicRepository.deleteById(id);
    }
}