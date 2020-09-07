package com.pristavka.patient_card.service;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.repo.AllergyRepository;
import com.pristavka.patient_card.service.dao.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllergyServiceImp implements AllergyService
{
    @Autowired
    private AllergyRepository allergyRepository;

    @Override
    public Allergy save(Allergy allergy)
    {
        return allergyRepository.save(allergy);
    }

    @Override
    public List<Allergy> findAll()
    {
        return allergyRepository.findAll();
    }

    @Override
    public List<Allergy> findAllByGroup(String groupName)
    {
        return allergyRepository.findAllByGroup(groupName);
    }

    @Override
    public Page<Allergy> findPaginated(int pageNo, int sizeNo)
    {
        Pageable pageable = PageRequest.of(pageNo - 1, sizeNo);
        return allergyRepository.findAll(pageable);
    }

    @Override
    public void deleteById(long id)
    {
        allergyRepository.deleteById(id);
    }
}

