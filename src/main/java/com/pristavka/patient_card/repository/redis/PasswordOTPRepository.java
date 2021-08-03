package com.pristavka.patient_card.repository.redis;

import com.pristavka.patient_card.model.redis.PasswordOTP;
import org.springframework.data.repository.CrudRepository;

public interface PasswordOTPRepository extends CrudRepository<PasswordOTP, String> {
}

