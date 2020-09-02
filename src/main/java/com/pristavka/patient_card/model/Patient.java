package com.pristavka.patient_card.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pristavka.patient_card.resources.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column(updatable = false)
    private long id;

    @Column(length = 40, nullable = false)
    private String firstName;

    @Column(length = 50, nullable = false)
    private String lastName;

    @Column(nullable = false)
    @JsonFormat(pattern = Constant.DATE_TEMPLATE)
    private LocalDateTime admissionDate;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Diagnosis> diagnoses = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    Set<Allergy> allergies = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clinic clinic;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private int ward;
}

