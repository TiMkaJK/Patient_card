package com.pristavka.patient_card.model.mongo;

import com.pristavka.patient_card.model.Patient;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "drugs")
public class Drug {

    @Id
    @Field(name = "_id")
    private String _id;

    @Field(name = "name")
    private String name;

    @Field(name = "manufactureDate")
    private LocalDate manufactureDate;

    private Manufacturer manufacturer;

    private Coordinates coordinates;

    private Set<String> contraindications;

    private List<Patient> patients;
}

