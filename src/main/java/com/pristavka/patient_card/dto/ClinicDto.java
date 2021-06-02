package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicDto {

    @Size(max = 50)
    private String name;

    private int number;
    private Set<Patient> patients;
}

