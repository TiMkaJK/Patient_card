package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.StatusDto;
import com.pristavka.patient_card.model.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface StatusMapper
{
    StatusDto statusToStatusDto(Status model);

    Status statusDtoToStatus(StatusDto dto);

    List<StatusDto> statusToStatusDto(List<Status> list);
}
