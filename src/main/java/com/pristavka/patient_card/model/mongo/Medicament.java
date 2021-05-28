package com.pristavka.patient_card.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "medicines")
public class Medicament {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "manufactureDate")
    private LocalDateTime manufactureDate;

    private Manufacturer manufacturer;

    private Coordinates coordinates;

    private Set<String> contraindications;
}

