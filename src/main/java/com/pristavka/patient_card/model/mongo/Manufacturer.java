package com.pristavka.patient_card.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Manufacturer {

    private String name;
    private String city;
    private String street;
    private String index;
}

