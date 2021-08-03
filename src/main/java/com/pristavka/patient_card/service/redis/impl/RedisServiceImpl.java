package com.pristavka.patient_card.service.redis.impl;

import com.pristavka.patient_card.model.redis.PasswordOTP;
import com.pristavka.patient_card.repository.redis.PasswordOTPRepository;
import com.pristavka.patient_card.service.redis.RedisService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private PasswordOTPRepository passwordOTPRepository;

    @Override
    public PasswordOTP getById(String id) throws NotFoundException {
        return this.passwordOTPRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("OTP Code not found"));
    }

    @Override
    public PasswordOTP save(PasswordOTP passwordOTP) {
        return this.passwordOTPRepository.save(passwordOTP);
    }

    @Override
    public void delete(String id) {
        this.passwordOTPRepository.deleteById(id);
    }
}

