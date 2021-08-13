package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.ClinicDto;
import com.pristavka.patient_card.mapper.ClinicMapper;
import com.pristavka.patient_card.service.jpa.ClinicService;
import com.pristavka.patient_card.utils.PageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.InputMismatchException;

@RestController
@RequestMapping(path = "/api/v1/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private ClinicMapper clinicMapper;

    @GetMapping(path = "/")
    public ResponseEntity<Page<ClinicDto>> getClinics(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertClinics(this.clinicService.getClinics(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClinicDto> getClinic(@PathVariable(name = "id") @Min(1) Long id) {
        return new ResponseEntity<>(this.clinicMapper.toDto(this.clinicService.getClinic(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<ClinicDto> saveClinic(@RequestBody @Valid ClinicDto clinicDto,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputMismatchException();
        }

        var clinic = this.clinicService.save(this.clinicMapper.toEntity(clinicDto));

        return new ResponseEntity<>(this.clinicMapper.toDto(clinic), HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<ClinicDto> updateClinic(@RequestBody @Valid ClinicDto clinicDto,
                                                  BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputMismatchException();
        }

        var clinic = this.clinicService.update(this.clinicMapper.toEntity(clinicDto));

        return new ResponseEntity<>(this.clinicMapper.toDto(clinic), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteClinic(@PathVariable(name = "id") @Min(1) Long id) {
        this.clinicService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
