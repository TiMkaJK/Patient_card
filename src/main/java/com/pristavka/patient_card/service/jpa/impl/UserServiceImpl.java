package com.pristavka.patient_card.service.jpa.impl;

import com.pristavka.patient_card.model.jpa.User;
import com.pristavka.patient_card.repository.jpa.UserRepository;
import com.pristavka.patient_card.security.SecurityUser;
import com.pristavka.patient_card.service.jpa.UserService;
import com.pristavka.patient_card.services.EmailSenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailSenderService emailSenderService;

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public User getUser(Long id) {
        return this.userRepository.getById(id);
    }

    @Override
    public User save(User user) throws MessagingException {

        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        this.emailSenderService.sendEmail("dmytro.prystavka@faceit.com.ua","Test","251086");

        return this.userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = this.userRepository.findByEmail(email);

        Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new SecurityUser(user).getUserDetails();
    }
}

