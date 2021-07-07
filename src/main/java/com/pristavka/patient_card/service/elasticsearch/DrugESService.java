package com.pristavka.patient_card.service.elasticsearch;

import com.pristavka.patient_card.model.mongo.Drug;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface DrugESService {

    List<Drug> findDrugByName(String name);

    List<Drug> findDrugsGreaterThan(LocalDate dateFrom, LocalDate dateTo);

    List<Drug> findDrugGeoLocation(String latitude, String longitude, Integer distance);

    List<Drug> getDrugsWithGroupingBy();

    List<Drug> findDrugsByNameWithMistakes(String name);

    List<Drug> findDrugsByPrefix(String prefix, Pageable pageable);

    List<Drug> findDrugsByNameAndContraindications(String name, String contraindications);

    List<Drug> findDrugsWithWildcard(String begin, String end);
}

