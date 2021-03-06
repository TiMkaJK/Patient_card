package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.DrugDto;
import com.pristavka.patient_card.dto.PatientDrugDto;
import com.pristavka.patient_card.mapper.PatientDrugMapper;
import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.service.DrugService;
import com.pristavka.patient_card.service.PatientDrugService;
import com.pristavka.patient_card.utils.PageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/drugs")
public class DrugRestController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private PatientDrugService patientDrugService;

    @Autowired
    private PatientDrugMapper patientDrugMapper;

    @GetMapping(path = "/")
    public ResponseEntity<Page<DrugDto>> getDrugs(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertDrugs(this.drugService.getDrugs(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/saveDrugsToMongoDB")
    public void saveDrugsToMongoDB() {

        try {
            this.drugService.saveDrugsToMongoDB();
        } catch (Exception e) {
            throw new RuntimeException("Error saving drugs to MongoDb");
        }
    }

    @GetMapping(path = "/saveDrugsToES")
    public void saveDrugsToES() {

        try {
            this.drugService.saveDrugsToES();
        } catch (Exception e) {
            throw new RuntimeException("Error saving drugs to Elasticsearch");
        }
    }

    @PostMapping(path = "/save-patient-drug")
    public void savePatientDrug(@RequestBody PatientDrugDto patientDrugDto) {
        this.patientDrugService.save(this.patientDrugMapper.toEntity(patientDrugDto));
    }
}

