package com.pristavka.patient_card.model.redis;

import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "PasswordOTP")
public class PasswordOTP implements Serializable {

    private String id;

    @Size(max = 6)
    private String otpCode;
    private LocalDateTime startDate;

    @TimeToLive(unit = TimeUnit.MINUTES)
    private int timeToLive;
}

