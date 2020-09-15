package com.pristavka.patient_card.service;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

public interface UserService extends UserDetailsService
{
    User findByEmail(String email);

    User save(UserDto userDto);
}
