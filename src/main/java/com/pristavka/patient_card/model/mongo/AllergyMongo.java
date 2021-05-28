package com.pristavka.patient_card.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "allergy")
public class AllergyMongo {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "group")
    private String group;
}


