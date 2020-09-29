package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.ClinicDto;
import com.pristavka.patient_card.model.Clinic;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClinicMapper
{
    ClinicMapper INSTANCE = Mappers.getMapper(ClinicMapper.class);

    ClinicDto toDto(Clinic model);

    Clinic toModel(ClinicDto dto);

    List<ClinicDto> toDtoList(List<Clinic> list);
}
