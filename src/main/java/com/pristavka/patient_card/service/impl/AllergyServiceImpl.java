package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.repo.AllergyRepository;
import com.pristavka.patient_card.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AllergyServiceImpl implements AllergyService
{
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public Allergy save(Allergy allergy)
    {
        return this.allergyRepository.save(allergy);
    }

    @Override
    public List<Allergy> findAll()
    {
        return this.allergyRepository.findAll();
    }

    @Override
    public List<Allergy> findAllByGroup(String group)
    {
        return this.allergyRepository.findAllByGroup(group);
    }

    @Override
    public Page<Allergy> findAll(Pageable pageable)
    {
        return this.allergyRepository.findAll(pageable);
    }
}

