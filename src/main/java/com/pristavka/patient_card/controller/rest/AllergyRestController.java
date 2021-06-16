package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/allergies")
public class AllergyRestController {

    @Autowired
    private AllergyMapper allergyMapper;

    @Autowired
    private AllergyService allergyService;

    @GetMapping(path = "/")
    public Allergy saveAllergy(@RequestBody AllergyDto allergyDto) {
        return this.allergyService.save(this.allergyMapper.toEntity(allergyDto));
    }

    @GetMapping(path = "/")
    public Page<Allergy> getAllergies(Pageable pageable) {
        return this.allergyService.findAll(pageable);
    }

    @GetMapping(path = "/{group}")
    public List<AllergyDto> getAllergiesByGroup(@PathVariable @NotBlank String group) {
        return this.allergyMapper.toDtoList(this.allergyService.findAllByGroup(group));
    }
}

