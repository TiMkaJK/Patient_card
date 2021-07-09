package com.pristavka.patient_card.model.elasticsearch;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ManufacturerES {

    @Field(type = FieldType.Keyword)
    private String name;

    @Field(type = FieldType.Keyword)
    private String city;

    @Field(type = FieldType.Text)
    private String street;

    @Field(type = FieldType.Text)
    private String index;
}

