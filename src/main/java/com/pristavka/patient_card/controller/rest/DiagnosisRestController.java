package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.DiagnosisDto;
import com.pristavka.patient_card.mapper.DiagnosisMapper;
import com.pristavka.patient_card.service.DiagnosisService;
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
@RequestMapping(path = "/api/v1/diagnoses")
public class DiagnosisRestController {

    @Autowired
    private DiagnosisService diagnosisService;

    @Autowired
    private DiagnosisMapper diagnosisMapper;

    @GetMapping(path = "/")
    public ResponseEntity<Page<DiagnosisDto>> getDiagnoses(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertDiagnosis(this.diagnosisService.getDiagnoses(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiagnosisDto> getDiagnosis(@PathVariable(name = "id") @Min(1) Long id) {
        return  new ResponseEntity<>(this.diagnosisMapper.toDto(this.diagnosisService.getDiagnosis(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public DiagnosisDto saveDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        return this.diagnosisMapper.toDto(this.diagnosisService.save(this.diagnosisMapper.toEntity(diagnosisDto)));
    }

    @PutMapping(path = "/")
    public ResponseEntity<DiagnosisDto> updateDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        return new ResponseEntity<>(this.diagnosisMapper.toDto(this.diagnosisService.update(this.diagnosisMapper.toEntity(diagnosisDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDiagnosis(@PathVariable(name = "id") @Min(1) Long id) {
        this.diagnosisService.delete(id);
    }
}

