package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.jpa.Allergy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllergyMapper {

    AllergyDto toDto(Allergy entity);

    Allergy toEntity(AllergyDto dto);

    List<AllergyDto> toDtoList(List<Allergy> list);

}
