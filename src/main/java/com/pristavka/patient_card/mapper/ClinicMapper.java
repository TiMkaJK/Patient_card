package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.ClinicDto;
import com.pristavka.patient_card.model.Clinic;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClinicMapper {

    ClinicDto toDto(Clinic model);

    Clinic toModel(ClinicDto dto);

    List<ClinicDto> toDtoList(List<Clinic> list);
}
