package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.mongo.AllergyMongo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AllergyMapper {

    AllergyDto toDto(Allergy entity);

    Allergy toEntity(AllergyDto dto);

    List<AllergyDto> toDtoList(List<Allergy> list);

    AllergyMongo toMongo(Allergy entity);

    List<AllergyMongo> toMongoList(List<Allergy> list);
}
