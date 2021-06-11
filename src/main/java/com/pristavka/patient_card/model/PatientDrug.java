package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "patient")
@Table(name = "patient_drug")
public class PatientDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "drug_id")
    private String drugId;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "quantity")
    private int quantity;
}

