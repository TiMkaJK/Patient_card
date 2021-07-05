package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.PatientDto;
import com.pristavka.patient_card.model.Patient;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClinicMapper.class, UserMapper.class})
public interface PatientMapper {

    PatientDto toDto(Patient model);

    Patient toEntity(PatientDto dto);

    List<PatientDto> toDtoList(List<Patient> list);
}
