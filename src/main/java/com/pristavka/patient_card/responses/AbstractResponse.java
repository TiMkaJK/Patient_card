package com.pristavka.patient_card.responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class AbstractResponse {
    private int status;
    private int code;
}

