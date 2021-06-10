package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PatientDrugDto {

    private Long id;

    private Patient patient;

    private String drugId;

    private LocalDateTime purchaseDate;

    private int quantity;
}

