package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    UserDto toDto(User model);

    User toModel(UserDto dto);

    List<UserDto> toDtoList(List<User> list);
}
