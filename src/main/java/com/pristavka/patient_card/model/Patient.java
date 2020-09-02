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
import java.util.List;

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

    @Column(columnDefinition = "VARCHAR",length = 40, nullable = false)
    private String firstName;

    @Column(columnDefinition = "VARCHAR",length = 50, nullable = false)
    private String lastName;

    private String receiptDate;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Clinic clinic;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Diagnosis> diagnoses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<Allergy> allergies = new ArrayList<>();

    @Column(columnDefinition = "DATETIME",nullable = false)
    @JsonFormat(pattern = Constant.DATE_TEMPLATE)
    private LocalDateTime dateTime;

    @Column(columnDefinition = "SMALLINT", nullable = false)
    private int floor;

    @Column(columnDefinition = "SMALLINT", nullable = false)
    private int ward;
}

