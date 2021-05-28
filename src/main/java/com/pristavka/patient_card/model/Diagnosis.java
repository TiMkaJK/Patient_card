package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

//@Data
@Getter
@Setter
@EqualsAndHashCode(exclude = "patients")
@ToString(exclude = "patients")
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "diagnoses")
    private Set<Patient> patients;
}

