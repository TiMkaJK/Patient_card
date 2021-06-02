package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiagnosisDto {

    @Size(max = 100)
    @NotNull
    private String name;
    private Set<Patient> patients;
}

