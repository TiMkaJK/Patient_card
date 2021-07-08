package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.mapper.PatientMapper;
import com.pristavka.patient_card.service.PatientService;
import com.pristavka.patient_card.utils.PageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/patients")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientMapper patientMapper;

    @GetMapping(path = "/")
    public ResponseEntity<Page<PatientDto>> getPatients(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertPatients(this.patientService.getPatients(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public PatientDto getPatient(@PathVariable(name = "id") @Min(1) Long id) {
        return this.patientMapper.toDto(this.patientService.getPatient(id));
    }

    @PostMapping(path = "/")
    public PatientDto savePatient(@RequestBody PatientDto patientDto) {
        return this.patientMapper.toDto(this.patientService.save(this.patientMapper.toEntity(patientDto)));
    }

    @PutMapping(path = "/")
    public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
        return new ResponseEntity<>(this.patientMapper.toDto(this.patientService.update(this.patientMapper.toEntity(patientDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePatient(@PathVariable(name = "id") @Min(1) Long id) {
        this.patientService.delete(id);
    }
}

