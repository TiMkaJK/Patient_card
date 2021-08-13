package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.jpa.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    UserDto toDto(User model);

    User toEntity(UserDto dto);

    List<UserDto> toDtoList(List<User> list);
}
