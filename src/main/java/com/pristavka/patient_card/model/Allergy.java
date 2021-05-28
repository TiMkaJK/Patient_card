package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "patients")
@ToString(exclude = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 50, nullable = false, unique = true)
    @Size(min = 1, max = 50)
    private String name;

    @Column(name = "group", length = 50)
    @Size(min = 1, max = 50)
    //@Transient
    private String group;

    @ManyToMany(mappedBy = "allergies")
    private Set<Patient> patients;
}

