package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User model);

    User toEntity(UserDto dto);

    List<UserDto> toDtoList(List<User> list);
}
