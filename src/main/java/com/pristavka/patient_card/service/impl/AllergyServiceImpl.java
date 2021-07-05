package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.repository.AllergyRepository;
import com.pristavka.patient_card.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class AllergyServiceImpl implements AllergyService
{
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public Allergy save(Allergy allergy)
    {
        return this.allergyRepository.save(allergy);
    }

    @Transactional
    @Override
    public Allergy update(Allergy allergy) {
        return this.allergyRepository.save(allergy);
    }

    @Override
    public Allergy getAllergy(Long id) {
        return this.allergyRepository.getById(id);
    }

    @Override
    public List<Allergy> findAllByGroup(String group)
    {
        return this.allergyRepository.findAllByGroup(group);
    }

    @Override
    public Page<Allergy> getAllergies(Pageable pageable)
    {
        return this.allergyRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
        this.allergyRepository.deleteById(id);
    }
}

