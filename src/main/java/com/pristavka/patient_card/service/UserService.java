package com.pristavka.patient_card.service;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService
{
    User findByEmail(String email);

    User save(UserDto userDto);
}
