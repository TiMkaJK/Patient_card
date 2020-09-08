package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.dto.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(AllergyController.ALLERGY_URL)
@Slf4j
public class AllergyController
{
    public static final String ALLERGY_URL = "/allergies";

    private AllergyMapper mapper;

    @Autowired
    private AllergyServiceImp allergyServiceImp;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Allergy saveAllergy(@RequestBody AllergyDto allergyDto)
    {
        return this.allergyServiceImp.save(mapper.allergyDtoToAllergy(allergyDto));
    }


    @GetMapping
    public List<Allergy> findAllAllergies()
    {
        List<Allergy> allergies = this.allergyServiceImp.findAll();

        String foodName = "food";

        System.out.println(allergies);

        //allergies.stream().forEachOrdered(allergy -> System.out.println(allergy.getName()));

        List<Allergy> allergiesByGroup = allergies.stream()
                                                  .filter(allergy -> allergy.getGroup() == foodName )
                                                  .collect(Collectors.toList());

        log.debug(allergiesByGroup.toString());

        return this.allergyServiceImp.findAll();
        //return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAll());
    }

    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    public Page<Allergy> allergiesPageable(Pageable pageable)
    {
        return this.allergyServiceImp.findAll(pageable);
    }

    @PostMapping
    public List<AllergyDto> findAllAllergiesByGroup(@RequestBody AllergyDto allergyDto)
    {
        return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAllByGroup(mapper.allergyDtoToAllergy(allergyDto)));
    }
}

