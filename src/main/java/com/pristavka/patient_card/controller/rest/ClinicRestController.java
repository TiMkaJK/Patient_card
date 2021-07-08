package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.ClinicDto;
import com.pristavka.patient_card.mapper.ClinicMapper;
import com.pristavka.patient_card.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private ClinicMapper clinicMapper;

    @GetMapping(path = "/")
    public ResponseEntity<List<ClinicDto>> getClinics() {
        return new ResponseEntity<>(this.clinicMapper.toDtoList(this.clinicService.getClinics()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClinicDto> getClinic(@PathVariable(name = "id") @Min(1) Long id) {
        return new ResponseEntity<>(this.clinicMapper.toDto(this.clinicService.getClinic(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public ResponseEntity<ClinicDto> saveClinic(@RequestBody ClinicDto clinicDto) {
        return new ResponseEntity<>(this.clinicMapper.toDto(this.clinicService.save(this.clinicMapper.toEntity(clinicDto))), HttpStatus.OK);
    }

    @PutMapping(path = "/")
    public ResponseEntity<ClinicDto> updateClinic(@RequestBody ClinicDto clinicDto) {
        return new ResponseEntity<>(this.clinicMapper.toDto(this.clinicService.update(this.clinicMapper.toEntity(clinicDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteClinic(@PathVariable(name = "id") @Min(1) Long id) {
        this.clinicService.delete(id);
    }
}
