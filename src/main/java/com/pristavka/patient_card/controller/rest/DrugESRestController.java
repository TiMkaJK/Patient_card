package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.service.elasticsearch.DrugESService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "/api/v1/es/drugs")
public class DrugESRestController {

    @Autowired
    private DrugESService drugESService;

    @GetMapping(path = "/name/{name}")
    public List<Drug> getDrugByName(@PathVariable("name") @NotBlank String name) {
        return this.drugESService.findDrugByName(name);
    }

    @GetMapping(path = "/date")
    public List<Drug> findDrugsGreaterThan(@RequestParam("dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
                                           @RequestParam("dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo) {
        return this.drugESService.findDrugsGreaterThan(dateFrom, dateTo);
    }

    @GetMapping(path = "/geoDistance")
    public List<Drug> findDrugGeoLocation(@RequestParam("latitude") @NotBlank String latitude,
                                          @RequestParam("longitude") @NotBlank String longitude,
                                          @RequestParam("distance") Integer distance) {
        return this.drugESService.findDrugGeoLocation(latitude, longitude, distance);
    }

    @GetMapping(path = "/mistake/{name}")
    public List<Drug> findDrugsByNameWithMistakes(@PathVariable("name") @NotBlank String name) {
        return this.drugESService.findDrugsByNameWithMistakes(name);
    }

    @GetMapping(path = "/prefix/{prefix}")
    public List<Drug> findDrugsByPrefix(@PathVariable("prefix") @NotBlank String prefix) {
        return this.drugESService.findDrugsByPrefix(prefix);
    }

    @GetMapping(path = "/nameAndContraindications/{name}/{contraindications}")
    public List<Drug> findDrugsByNameAndContraindications(@PathVariable @NotBlank String name,
                                                          @PathVariable @NotBlank String contraindications) {
        return this.drugESService.findDrugsByNameAndContraindications(name, contraindications);
    }
}

