package com.pristavka.patient_card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
@Table
public class Patient
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime admissionDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Diagnosis> diagnoses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<Allergy> allergies;

    @ManyToOne
    @JoinColumn
    private Clinic clinic;

    @ManyToOne
    @JoinColumn
    private User user;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private int ward;
}

