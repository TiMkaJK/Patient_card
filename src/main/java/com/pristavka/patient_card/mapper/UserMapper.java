package com.pristavka.patient_card.mapper;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper
{
    UserDto userToUserDto(User model);

    User userDtoToUser(UserDto dto);

    List<UserDto> userToUserDtoList(List<User> list);
}
