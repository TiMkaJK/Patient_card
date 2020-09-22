package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.RoleDto;
import com.pristavka.patient_card.model.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper
{
    RoleDto roleToRoleDto(Role model);

    Role roleDtoToRole(RoleDto dto);

    List<RoleDto> roleToRoleDto(List<Role> list);
}

