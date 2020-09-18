package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.model.User;

import java.time.LocalDateTime;
import java.util.Set;

public class PatientDto
{
    private String firstName;
    private String lastName;
    private LocalDateTime admissionDate;
    private Set<Diagnosis> diagnoses;
    private Set<Allergy> allergies;
    private Clinic clinic;
    private User user;
    private int floor;
    private int ward;
}

