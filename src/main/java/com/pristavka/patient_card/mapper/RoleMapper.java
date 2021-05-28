package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.RoleDto;
import com.pristavka.patient_card.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto toDto(Role model);

    Role toModel(RoleDto dto);

    List<RoleDto> toDtoList(List<Role> list);
}

