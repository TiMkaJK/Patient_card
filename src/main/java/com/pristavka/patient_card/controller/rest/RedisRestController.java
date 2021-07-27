package com.pristavka.patient_card.controller.rest;

import com.pristavka.patient_card.model.redis.PasswordOTP;
import com.pristavka.patient_card.service.redis.RedisService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/v1/redis")
public class RedisRestController {

    @Autowired
    private RedisService redisService;

    @PostMapping(path = "/")
    public ResponseEntity<String> save(@RequestBody @Valid PasswordOTP password) {

        if (Objects.isNull(this.redisService.save(password))) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PasswordOTP> getById(@PathVariable(name = "id") @NotBlank String id) throws NotFoundException {
        return new ResponseEntity<>(this.redisService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") @NotBlank String id) {

        this.redisService.delete(id);

        return ResponseEntity.ok().build();
    }
}

