package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.dto.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyServiceImp;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

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
    @Operation(summary = "Return list of all allergies")
    public List<Allergy> findAllAllergies()
    {
        List<Allergy> allergies = this.allergyServiceImp.findAll();

        String foodName = "food";

        //allergies.forEach(allergy -> log.warn(allergy.getName()));

        /*List<Allergy> allergiesByGroup = allergies.stream()
                                                    .filter(allergy -> allergy.getGroup().equals(foodName))
                                                    .collect(Collectors.toList());
        log.warn(allergiesByGroup.toString());*/

        /*long count = allergies.stream()
                                .filter(allergy -> allergy.getGroup().equals(foodName))
                                .count();
        log.warn("count: " + count);*/

        /*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName) &&
                                                               allergy.getId() < 100)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*/

        /*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName))
                                                       .filter(allergy -> allergy.getId() > 100)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*/

        /*Optional<Allergy> lastAllegry = allergies.stream().skip(allergies.size() - 1).findAny();
        log.warn(lastAllegry.toString());*/

        /*List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .filter(allergy -> allergy.getGroup().equals(foodName))
                                                       .limit(20)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*/

       /* List<Allergy> allergiesByGroupAndId = allergies.stream()
                                                       .skip(5)
                                                       .limit(20)
                                                       .collect(Collectors.toList());
        log.warn(allergiesByGroupAndId.toString());*/

        /*Optional<Allergy> allergys = allergies.stream().filter(allergy -> allergy.getName().equals("Dandelions")).findAny();
        log.warn("id - " + allergys.get().getId());*/


        /*List<Allergy> allergiesSortByGroup = allergies.stream()
                                                      .sorted(Comparator.comparing(Allergy::getGroup))
                                                      .collect(Collectors.toList());
        for (Allergy allergy: allergiesSortByGroup)
        {
            log.warn(allergy.toString());
        }*/

        /*Map<String, List<Allergy>> allergiesSortByGroup = allergies.stream()
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(Allergy::getGroup,Collectors.toList()),
                        allergiesSortByGroup.values().forEach(a -> a.sort(Comparator.comparing(Allergy::getName))));*/

        Map<String, List<Allergy>> allergiesSortByGroup = allergies.stream().
                collect(Collectors.groupingBy(Allergy::getGroup,Collectors.toList()));
        allergiesSortByGroup.values().forEach(a -> a.sort(Comparator.comparing(Allergy::getName)));

        for (String key : allergiesSortByGroup.keySet())
        {
            log.warn(key + "" + allergiesSortByGroup.get(key));
        }

        //return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAll());
        return this.allergyServiceImp.findAll();
    }

    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    public Page<Allergy> allergiesPageable(Pageable pageable)
    {
        return this.allergyServiceImp.findAll(pageable);
    }

    //@RequestMapping(value = "/{group}", method = RequestMethod.GET)
    @GetMapping("/{group}")
    public List<AllergyDto> findAllAllergiesByGroup(@RequestBody AllergyDto allergyDto)
    {
        return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAllByGroup(mapper.allergyDtoToAllergy(allergyDto)));
    }
}

