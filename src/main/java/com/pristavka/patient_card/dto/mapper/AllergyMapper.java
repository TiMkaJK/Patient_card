package com.pristavka.patient_card.dto.mapper;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.Allergy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AllergyMapper
{
    //AllergyMapper INSTANCE = Mappers.getMapper(AllergyMapper.class);

    AllergyDto allergyToAllergyDto(Allergy model);

    Allergy allergyDtoToAllergy(AllergyDto dto);

    List<AllergyDto> allergyToAllergyDtoList(List<Allergy> list);
}
