package com.pristavka.patient_card.model.elasticsearch;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ManufacturerES {

    private String name;
    private String city;
    private String street;
    private String index;
}

