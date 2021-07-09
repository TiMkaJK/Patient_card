package com.pristavka.patient_card.model.elasticsearch;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CoordinatesES {

    private String latitude;
    private String longitude;
}

