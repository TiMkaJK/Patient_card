package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(exclude = "patients")
@ToString(exclude = "patients")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "number", nullable = false)
    private int number;

    @OneToMany(mappedBy = "clinic")
    private Set<Patient> patients;
}

