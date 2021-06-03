package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.repository.UserRepository;
import com.pristavka.patient_card.security.SecurityUser;
import com.pristavka.patient_card.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByEmail(String email)
    {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User save(UserDto userDto)
    {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        User user = this.userRepository.findByEmail(email);

        Optional.ofNullable(user).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new SecurityUser(user).getUserDetails();
    }
}

