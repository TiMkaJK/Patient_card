package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    @Size(min = 1, max = 50)
    private String name;

    @Column(name = "group", length = 50)
    @Size(min = 1, max = 50)
    //@Transient
    private String group;

    @ManyToMany(mappedBy = "allergies")
    private Set<Patient> patients = new HashSet<>();
}

