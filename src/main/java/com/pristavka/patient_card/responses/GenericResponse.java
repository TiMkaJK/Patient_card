package com.pristavka.patient_card.responses;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericResponse<T> extends AbstractResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private T response;

    public GenericResponse(int status, int code, T response) {
        super(status, code);
        this.response = response;
    }
}

