package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.model.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {

    PatientDto toDto(Patient model);

    Patient toModel(PatientDto dto);

    List<PatientDto> toDtoList(List<Patient> list);
}
