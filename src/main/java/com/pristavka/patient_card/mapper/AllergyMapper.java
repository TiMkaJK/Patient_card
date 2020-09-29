package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.Allergy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AllergyMapper
{
    AllergyMapper INSTANCE = Mappers.getMapper(AllergyMapper.class);

    AllergyDto toDto(Allergy model);

    Allergy toModel(AllergyDto dto);

    List<AllergyDto> toDtoList(List<Allergy> list);
}
