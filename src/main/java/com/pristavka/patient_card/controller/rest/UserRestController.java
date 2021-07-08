package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.dto.UserDto;
import com.pristavka.patient_card.mapper.UserMapper;
import com.pristavka.patient_card.service.UserService;
import com.pristavka.patient_card.utils.PageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(path = "/")
    public ResponseEntity<Page<UserDto>> getUsers(Pageable pageable) {
        return new ResponseEntity<>(PageConverter.convertUsers(this.userService.getUsers(pageable)), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable(name = "id") @Min(1) Long id) {
        return this.userMapper.toDto(this.userService.getUser(id));
    }

    @PostMapping(path = "/")
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return this.userMapper.toDto(this.userService.save(this.userMapper.toEntity(userDto)));
    }

    @PutMapping(path = "/")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return this.userMapper.toDto(this.userService.update(this.userMapper.toEntity(userDto)));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable(name = "id") @Min(1) Long id) {
        this.userService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

