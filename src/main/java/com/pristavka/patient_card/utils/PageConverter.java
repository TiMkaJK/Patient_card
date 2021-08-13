package com.pristavka.patient_card.utils;

import com.pristavka.patient_card.dto.*;
import com.pristavka.patient_card.model.jpa.*;
import com.pristavka.patient_card.model.mongo.Drug;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class PageConverter {

    public static Page<DrugDto> convertDrugs(Page<Drug> entity) {
        return entity.map(drug -> new ModelMapper().map(drug, DrugDto.class));
    }

    public static Page<AllergyDto> convertAllergies(Page<Allergy> entity) {
        return entity.map(allergy -> new ModelMapper().map(allergy, AllergyDto.class));
    }

    public static Page<ClinicDto> convertClinics(Page<Clinic> entity) {
        return entity.map(clinic -> new ModelMapper().map(clinic, ClinicDto.class));
    }

    public static Page<DiagnosisDto> convertDiagnosis(Page<Diagnosis> entity) {
        return entity.map(diagnoses -> new ModelMapper().map(diagnoses, DiagnosisDto.class));
    }

    public static Page<PatientDto> convertPatients(Page<Patient> entity) {
        return entity.map(patient -> new ModelMapper().map(patient, PatientDto.class));
    }

    public static Page<UserDto> convertUsers(Page<User> entity) {
        return entity.map(user -> new ModelMapper().map(user, UserDto.class));
    }
}

