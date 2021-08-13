package com.pristavka.patient_card.service.redis.impl;

import com.pristavka.patient_card.model.redis.PasswordOTP;
import com.pristavka.patient_card.repository.redis.PasswordOTPRepository;
import com.pristavka.patient_card.service.redis.RedisService;
import javassist.NotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private PasswordOTPRepository passwordOTPRepository;

    @Override
    public List<PasswordOTP> getAll() {
        return IterableUtils.toList(this.passwordOTPRepository.findAll());
    }

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

