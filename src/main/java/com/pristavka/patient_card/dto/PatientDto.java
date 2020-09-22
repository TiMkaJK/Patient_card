package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDto
{
    @Size(max = 40)
    @NotNull
    private String firstName;

    @Size(max = 50)
    @NotNull
    private String lastName;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime admissionDate;
    private Set<Diagnosis> diagnoses;
    private Set<Allergy> allergies;
    private Clinic clinic;
    private User user;

    @NotNull
    private int floor;

    @NotNull
    private int ward;
}

