package com.pristavka.patient_card.responses;

import lombok.*;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericListResponse extends AbstractResponse {

    public static GenericListResponse NOT_FOUND = new GenericListResponse(404, 404, null);
    public static GenericListResponse EMPTY = new GenericListResponse(404, 404, Arrays.asList());

    private List<?> response;

    public GenericListResponse(int status, int code, List<?> response) {
        super(status, code);
        this.response = response;
    }
}

