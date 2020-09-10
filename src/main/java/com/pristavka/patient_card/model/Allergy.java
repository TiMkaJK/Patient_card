package com.pristavka.patient_card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Size(min = 1, max = 50)
    private String name;

    @Column(length = 50,name = "group")
    @Size(min = 1, max = 50)
    //@Transient
    private String group;

    @ManyToMany(mappedBy = "allergies")
    private Set<Patient> patients = new HashSet<>();
}

