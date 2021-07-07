package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
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
    public Page<Allergy> getAllergies(Pageable pageable) {
        return this.allergyService.getAllergies(pageable);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AllergyDto> getAllergy(@PathVariable(name = "id") @Min(1) Long id) {
        return new ResponseEntity<>(this.allergyMapper.toDto(this.allergyService.getAllergy(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public AllergyDto saveAllergy(@RequestBody AllergyDto allergyDto) {
        return this.allergyMapper.toDto(this.allergyService.save(this.allergyMapper.toEntity(allergyDto)));
    }

    @PutMapping(path = "/")
    public ResponseEntity<AllergyDto> updateAllergy(@RequestBody AllergyDto allergyDto) {
        return new ResponseEntity<>(this.allergyMapper.toDto(this.allergyService.update(this.allergyMapper.toEntity(allergyDto))), HttpStatus.OK);
    }

    @GetMapping(path = "/{group}")
    public List<AllergyDto> getAllergiesByGroup(@PathVariable(name = "group") @NotBlank String group) {
        return this.allergyMapper.toDtoList(this.allergyService.findAllByGroup(group));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteAllergy(@PathVariable(name = "id") @Min(1) Long id) {
        this.allergyService.delete(id);
    }
}

