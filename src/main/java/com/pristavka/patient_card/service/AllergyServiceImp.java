package com.pristavka.patient_card.service;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.repo.AllergyRepository;
import com.pristavka.patient_card.service.dao.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AllergyServiceImp implements AllergyService
{
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public Allergy save(Allergy allergy)
    {
        Allergy newAllergy = new Allergy();
        newAllergy.setName(allergy.getName());
        return this.allergyRepository.save(newAllergy);
    }

    @Override
    public List<Allergy> findAll()
    {
        return this.allergyRepository.findAll();
    }

    @Override
    public List<Allergy> findAllByGroup(Allergy allergy)
    {
        log.debug(allergy.getGroup());
        return this.allergyRepository.findAllByGroup(allergy.getGroup());
    }

    @Override
    public Page<Allergy> findAll(Pageable pageable)
    {
        return this.allergyRepository.findAll(pageable);
    }
}

