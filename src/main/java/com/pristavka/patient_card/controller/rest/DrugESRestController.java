package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.elasticsearch.DrugES;
import com.pristavka.patient_card.service.elasticsearch.impl.DrugESServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping(path = "/api/v1/es/drugs")
public class DrugESRestController {

    @Autowired
    private DrugESServiceImpl drugESService;

    @GetMapping(path = "/")
    public Iterable<DrugES> getDrugs() {
        return this.drugESService.findAll();
    }
}

