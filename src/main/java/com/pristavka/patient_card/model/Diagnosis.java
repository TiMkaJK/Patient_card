package com.pristavka.patient_card.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Diagnosis
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR", length = 100,nullable = false,unique = true)
    private String name;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private Patient patient;
}

