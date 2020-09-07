package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Allergy
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(length = 50)
    private String group;

    @ManyToMany(mappedBy = "allergies")
    private Set<Patient> employees = new HashSet<>();
}

