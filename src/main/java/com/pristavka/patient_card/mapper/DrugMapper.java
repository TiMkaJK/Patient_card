package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.DrugDto;
import com.pristavka.patient_card.model.mongo.Drug;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    DrugDto toDto(Drug model);

    Drug toModel(DrugDto dto);

    List<DrugDto> toDtoList(List<Drug> modelList);
}

