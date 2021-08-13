package com.pristavka.patient_card.service.jpa;

import com.pristavka.patient_card.model.jpa.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.mail.MessagingException;

public interface UserService extends UserDetailsService {

    Page<User> getUsers(Pageable pageable);

    User getUser(Long id);

    User save(User user) throws MessagingException;

    User update(User user);

    void delete(Long id);

    User findByEmail(String email);
}
