package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.repository.ClinicRepository;
import com.pristavka.patient_card.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Clinic> getClinics() {
        return this.clinicRepository.findAll();
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