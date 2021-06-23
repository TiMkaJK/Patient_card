package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.mapper.UserMapper;
import com.pristavka.patient_card.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "/")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(this.userMapper.toDtoList(this.userService.getUsers()), HttpStatus.OK);
    }
}

