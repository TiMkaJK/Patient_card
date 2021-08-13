package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.PatientDrugDto;
import com.pristavka.patient_card.model.jpa.PatientDrug;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientDrugMapper {

    PatientDrugDto toDto(PatientDrug patientDrug);

    PatientDrug toEntity(PatientDrugDto patientDrugDto);

    List<PatientDrugDto> toDtoList(List<PatientDrug> modelList);
}
