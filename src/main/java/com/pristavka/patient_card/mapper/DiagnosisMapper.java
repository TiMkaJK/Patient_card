package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.DiagnosisDto;
import com.pristavka.patient_card.model.Diagnosis;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiagnosisMapper
{
    DiagnosisMapper INSTANCE = Mappers.getMapper(DiagnosisMapper.class);

    DiagnosisDto toDto(Diagnosis model);

    Diagnosis toModel(DiagnosisDto dto);

    List<DiagnosisDto> toDtoList(List<Diagnosis> list);
}
