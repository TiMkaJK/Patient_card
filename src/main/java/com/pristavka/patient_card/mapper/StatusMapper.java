package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.StatusDto;
import com.pristavka.patient_card.model.jpa.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDto toDto(Status model);

    Status toEntity(StatusDto dto);

    List<StatusDto> toDtoList(List<Status> list);
}
