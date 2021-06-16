package com.pristavka.patient_card.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericStringResponse extends AbstractResponse {

    public static GenericStringResponse SUCCESS =  new GenericStringResponse(200,200,"OK");
    public static GenericStringResponse NOT_FOUND = new GenericStringResponse(404,404,"Not Found");

    private String response;

    public GenericStringResponse(int status, int code, String response) {
        super(status, code);
        this.response = response;
    }
}

