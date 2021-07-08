package com.pristavka.patient_card.service;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    Page<User> getUsers(Pageable pageable);

    User getUser(Long id);

    User save(User user);

    User update(User user);

    void delete(Long id);

    User findByEmail(String email);
}
