package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.mongo.Coordinates;
import com.pristavka.patient_card.model.mongo.Manufacturer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DrugDto {

    private String id;
    private String name;
    private LocalDate manufactureDate;
    private Manufacturer manufacturer;
    private Coordinates coordinates;
    private Set<String> contraindications = new HashSet<>();
}

