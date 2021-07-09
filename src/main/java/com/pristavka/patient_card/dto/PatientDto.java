package com.pristavka.patient_card.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.model.PatientDrug;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto {

    private Long id;

    @NotBlank
    @Size(max = 40)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime admissionDate;
    private Set<Diagnosis> diagnoses = new HashSet<>();
    private Set<Allergy> allergies = new HashSet<>();
    private ClinicDto clinic;
    private UserDto user;

    @NotNull
    private int floor;

    @NotNull
    private int ward;

    private Set<PatientDrug> patientDrugs = new HashSet<>();
}

