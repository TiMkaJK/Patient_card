package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.DiagnosisDto;
import com.pristavka.patient_card.model.Diagnosis;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiagnosisMapper {

    DiagnosisDto toDto(Diagnosis model);

    Diagnosis toModel(DiagnosisDto dto);

    List<DiagnosisDto> toDtoList(List<Diagnosis> list);
}
