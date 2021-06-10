package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.DrugDto;
import com.pristavka.patient_card.model.mongo.Drug;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DrugMapper {
    @Mappings(
            @Mapping(target = "id" , source = "model._id")
    )
    DrugDto toDto(Drug model);

    @Mappings(
            @Mapping(target = "_id", source = "dto.id")
    )
    Drug toModel(DrugDto dto);

    List<DrugDto> toDtoList(List<Drug> modelList);
}

