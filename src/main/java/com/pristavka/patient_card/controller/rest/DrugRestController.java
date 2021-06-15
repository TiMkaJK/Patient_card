package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.PatientDrugDto;
import com.pristavka.patient_card.mapper.DrugMapper;
import com.pristavka.patient_card.mapper.PatientDrugMapper;
import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.service.DrugService;
import com.pristavka.patient_card.service.PatientDrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "api/drugs")
public class DrugRestController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private PatientDrugService patientDrugService;

    @Autowired
    private DrugMapper drugMapper;

    @Autowired
    private PatientDrugMapper patientDrugMapper;

    @PostMapping(path = "/save-drugs")
    public void saveDrugs() {
        this.drugService.saveDrugs();
    }

    @GetMapping(path = "/list-pageable")
    public Page<Drug> getDrugs(Pageable pageable) {
        return this.drugService.getDrugs(pageable);
    }

    @PostMapping(path = "save-patient-drug")
    public void savePatientDrug(@RequestBody PatientDrugDto patientDrugDto) {
        this.patientDrugService.save(this.patientDrugMapper.toModel(patientDrugDto));
    }
}

