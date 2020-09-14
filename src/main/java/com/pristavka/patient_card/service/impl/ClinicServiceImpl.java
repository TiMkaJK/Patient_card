package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.repo.ClinicRepository;
import com.pristavka.patient_card.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImpl implements ClinicService
{
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic save(Clinic clinic)
    {
        return clinicRepository.save(clinic);
    }

    @Override
    public List<Clinic> findAll()
    {
        return clinicRepository.findAll();
    }

    @Override
    public void deleteById(long id)
    {
        clinicRepository.deleteById(id);
    }
}

