package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.model.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper
{
    PatientDto patientToPatientDto(Patient model);

    Patient patientDtoToPatient(PatientDto dto);

    List<PatientDto> patientToPatientDto(List<Patient> list);
}
