package com.pristavka.patient_card.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDto {

    private Long id;

    @Size(max = 50)
    private String name;

    private int number;
    //private Set<Patient> patients = new HashSet<>();
}

