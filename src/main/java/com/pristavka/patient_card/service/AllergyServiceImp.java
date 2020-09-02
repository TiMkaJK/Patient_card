package com.pristavka.patient_card.service;

import com.pristavka.patient_card.repo.AllergyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImp implements com.pristavka.patient_card.service.dao.AllergyService
{
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public com.pristavka.patient_card.model.Allergy save(com.pristavka.patient_card.model.Allergy allergy)
    {
        return allergyRepository.save(allergy);
    }

    @Override
    public List<com.pristavka.patient_card.model.Allergy> findAll()
    {
        return allergyRepository.findAll();
    }

    @Override
    public void deleteById(long id)
    {
        allergyRepository.deleteById(id);
    }
}

