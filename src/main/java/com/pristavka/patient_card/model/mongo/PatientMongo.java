package com.pristavka.patient_card.model.mongo;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patient")
public class PatientMongo {

    @Id
    @Field(name = "id")
    private String id;

    @Field(name = "first_name")
    private String firstName;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "admission_date")
    private LocalDateTime admissionDate;

    @Field(name = "clinic")
    private Clinic clinic;

    @Field(name = "user")
    private User user;

    @Field(name = "floor")
    private String floor;

    @Field(name = "ward")
    private String ward;
}

