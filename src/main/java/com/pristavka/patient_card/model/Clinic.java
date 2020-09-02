package com.pristavka.patient_card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Clinic
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "VARCHAR", length = 100, nullable = false)
    private String name;

    @Column(columnDefinition = "INT", nullable = false)
    private int number;

    @OneToOne
    private Patient patient;

    public Clinic(String name)
    {
        this.name = name;
    }
}

