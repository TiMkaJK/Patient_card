package com.pristavka.patient_card.utils;

import java.security.SecureRandom;

public class EmailUtils {

    public static final int BOUND = 9;
    public static final int OTP_SIZE = 6;

    public String generateOTP() {

        StringBuilder otp = new StringBuilder();
        SecureRandom number = new SecureRandom();

        for (int i = 0; i < OTP_SIZE; i++) {
            otp.append(number.nextInt(BOUND));
        }

        return otp.toString();
    }
}

