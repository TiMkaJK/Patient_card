package com.pristavka.patient_card.service;

import com.pristavka.patient_card.repo.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicServiceImp implements com.pristavka.patient_card.service.dao.ClinicService
{
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public com.pristavka.patient_card.model.Clinic save(com.pristavka.patient_card.model.Clinic clinic)
    {
        return clinicRepository.save(clinic);
    }

    @Override
    public List<com.pristavka.patient_card.model.Clinic> findAll()
    {
        return clinicRepository.findAll();
    }

    @Override
    public void deleteById(long id)
    {
        clinicRepository.deleteById(id);
    }
}

