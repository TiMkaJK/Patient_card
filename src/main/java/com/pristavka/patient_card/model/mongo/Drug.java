package com.pristavka.patient_card.model.mongo;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Document(collection = "drugs")
public class Drug {

    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "manufactureDate")
    private LocalDate manufactureDate;
    private Manufacturer manufacturer;
    private Coordinates coordinates;
    private Set<String> contraindications = new HashSet<>();
}

