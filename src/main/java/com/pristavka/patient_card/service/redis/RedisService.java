package com.pristavka.patient_card.service.redis;

import com.pristavka.patient_card.model.redis.PasswordOTP;
import javassist.NotFoundException;

public interface RedisService {

    PasswordOTP getById(String id) throws NotFoundException;

    PasswordOTP save(PasswordOTP passwordOTP);

    void delete(String id);
}

