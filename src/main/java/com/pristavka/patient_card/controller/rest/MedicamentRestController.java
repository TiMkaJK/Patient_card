package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.service.MedicamentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(path = "/api/medicines")
public class MedicamentRestController {

    @Autowired
    private MedicamentService medicamentService;

    @GetMapping(path = "/save")
    public void saveMedicines() {
        this.medicamentService.saveMedicines();
    }
}

