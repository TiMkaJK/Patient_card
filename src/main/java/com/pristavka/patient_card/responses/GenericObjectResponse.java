package com.pristavka.patient_card.responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GenericObjectResponse extends AbstractResponse {

    public static GenericStringResponse SUCCESS =  new GenericStringResponse(200,200,"OK");
    public static GenericStringResponse NOT_FOUND = new GenericStringResponse(404,404,"Not Found");

    private Object response;

    public GenericObjectResponse(int status, int code, Object response) {
        super(status, code);
        this.response = response;
    }
}

