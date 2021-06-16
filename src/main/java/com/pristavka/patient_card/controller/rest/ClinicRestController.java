package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.ClinicDto;
import com.pristavka.patient_card.mapper.ClinicMapper;
import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/v1/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private ClinicMapper clinicMapper;

    @PostMapping(path = "/")
    public Clinic saveClinic(@RequestBody String name) {

        Clinic clinic = new Clinic();
        clinic.setName(name);
        return this.clinicService.save(clinic);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<ClinicDto>> getClinics() {
        return new ResponseEntity<>(this.clinicMapper.toDtoList(this.clinicService.findAll()), HttpStatus.OK);
    }
}
