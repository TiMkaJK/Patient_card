package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.DiagnosisDto;
import com.pristavka.patient_card.mapper.DiagnosisMapper;
import com.pristavka.patient_card.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<DiagnosisDto> getDiagnoses() {
        return this.diagnosisMapper.toDtoList(this.diagnosisService.getDiagnoses());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DiagnosisDto> getDiagnosis(@PathVariable @Min(1) Long id) {
        return  new ResponseEntity<>(this.diagnosisMapper.toDto(this.diagnosisService.getDiagnosis(id)), HttpStatus.OK);
    }

    @PostMapping(path = "/")
    public DiagnosisDto saveDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        return this.diagnosisMapper.toDto(this.diagnosisService.save(this.diagnosisMapper.toModel(diagnosisDto)));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DiagnosisDto> updateDiagnosis(@RequestBody DiagnosisDto diagnosisDto) {
        return new ResponseEntity<>(this.diagnosisMapper.toDto(this.diagnosisService.update(this.diagnosisMapper.toModel(diagnosisDto))), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDiagnosis(@PathVariable @Min(1) Long id) {
        this.diagnosisService.delete(id);
    }
}

