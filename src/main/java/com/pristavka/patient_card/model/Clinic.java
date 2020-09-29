package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "patients")
@ToString(exclude = "patients")
@NoArgsConstructor
@AllArgsConstructor
public class Clinic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(nullable = false)
    private int number;

    @OneToMany(mappedBy = "clinic")
    private Set<Patient> patients;
}

