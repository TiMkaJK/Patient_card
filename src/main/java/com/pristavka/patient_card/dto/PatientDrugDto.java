package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Patient;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDrugDto {

    private Long id;
    private Patient patient;
    private String drugId;
    private LocalDateTime purchaseDate;
    private int quantity;
}

