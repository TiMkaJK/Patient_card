package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.repository.ClinicRepository;
import com.pristavka.patient_card.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClinicServiceImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic save(String name) {

        Clinic clinic = new Clinic();
        clinic.setName(name);

        Clinic savedClinic = this.clinicRepository.save(clinic);

        if (Objects.isNull(savedClinic)) {
            throw new IllegalArgumentException();
        }

        return savedClinic;
    }

    @Override
    public List<Clinic> findAll() {
        return this.clinicRepository.findAll();
    }

    @Override
    public void deleteById(long id) {
        this.clinicRepository.deleteById(id);
    }
}