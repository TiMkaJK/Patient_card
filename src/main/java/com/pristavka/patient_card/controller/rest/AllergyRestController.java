package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyService;
import com.pristavka.patient_card.utils.PageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.InputMismatchException;
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
    public ResponseEntity<Page<AllergyDto>> getAllergies(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertAllergies(this.allergyService.getAllergies(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AllergyDto> getAllergy(@PathVariable(name = "id") @Min(1) Long id) {
        return new ResponseEntity<>(this.allergyMapper.toDto(this.allergyService.getAllergy(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<AllergyDto> saveAllergy(@RequestBody @Valid AllergyDto allergyDto,
                                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputMismatchException();
        }

        var allergy = this.allergyMapper.toEntity(allergyDto);
        return new ResponseEntity<>(this.allergyMapper.toDto(this.allergyService.save(allergy)), HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<AllergyDto> updateAllergy(@RequestBody @Valid AllergyDto allergyDto,
                                                    BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputMismatchException();
        }

        var allergy = this.allergyService.update(this.allergyMapper.toEntity(allergyDto));
        return new ResponseEntity<>(this.allergyMapper.toDto(allergy), HttpStatus.OK);
    }

    @GetMapping(path = "/{group}")
    public ResponseEntity<List<AllergyDto>> getAllergiesByGroup(@PathVariable(name = "group") @NotBlank String group) {
        return new ResponseEntity<>(this.allergyMapper.toDtoList(this.allergyService.findAllByGroup(group)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteAllergy(@PathVariable(name = "id") @Min(1) Long id) {
        this.allergyService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

