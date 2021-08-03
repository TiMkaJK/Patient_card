package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.service.elasticsearch.DrugESService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@Api
@RestController
@RequestMapping(path = "/api/v1/es/elasticsearch")
public class ElasticsearchRestController {

    @Autowired
    private DrugESService drugESService;

    @GetMapping(path = "/name/{name}")
    public List<Drug> getDrugByName(@PathVariable(name = "name") @NotBlank String name) {
        return this.drugESService.findDrugByName(name);
    }

    @GetMapping(path = "/date")
    public List<Drug> findDrugsGreaterThan(@RequestParam(name = "dateFrom") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
                                           @RequestParam(name = "dateTo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo) {
        return this.drugESService.findDrugsGreaterThan(dateFrom, dateTo);
    }

    @GetMapping(path = "/geoDistance")
    public List<Drug> findDrugGeoLocation(@RequestParam(name = "latitude") @NotBlank String latitude,
                                          @RequestParam(name = "longitude") @NotBlank String longitude,
                                          @RequestParam(name = "distance") Integer distance) {
        return this.drugESService.findDrugGeoLocation(latitude, longitude, distance);
    }

    @GetMapping(path = "/mistake/{name}")
    public List<Drug> findDrugsByNameWithMistakes(@PathVariable(name = "name") @NotBlank String name) {
        return this.drugESService.findDrugsByNameWithMistakes(name);
    }

    @GetMapping(path = "/prefix/{prefix}")
    public List<Drug> findDrugsByPrefix(@PathVariable(name = "prefix") @NotBlank String prefix,
                                        Pageable pageable) {
        return this.drugESService.findDrugsByPrefix(prefix, pageable);
    }

    @GetMapping(path = "/nameAndContraindications/{name}/{contraindications}")
    public List<Drug> findDrugsByNameAndContraindications(@PathVariable(name = "name") @NotBlank String name,
                                                          @PathVariable(name = "contraindications") @NotBlank String contraindications) {
        return this.drugESService.findDrugsByNameAndContraindications(name, contraindications);
    }

    @GetMapping(path = "/groupingBy")
    public List<Drug> getDrugsWithGroupingBy() {
        return this.drugESService.getDrugsWithGroupingBy();
    }

    @GetMapping(path = {"/wildcard/{begin}", "/wildcard/{begin}/{end}"})
    public List<Drug> findDrugsWithWildcard(@PathVariable(name = "begin") @NotBlank String begin,
                                            @PathVariable(name = "end", required = false) @NotBlank String end) {
        return this.drugESService.findDrugsWithWildcard(begin, end);
    }

    @GetMapping(path = "/aggregations")
    public List<Drug> getDrugsWithAggregations() {
        return this.drugESService.getDrugsWithAggregations();
    }
}

