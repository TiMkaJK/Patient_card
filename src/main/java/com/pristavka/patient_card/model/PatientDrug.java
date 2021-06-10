package com.pristavka.patient_card.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient_drug")
public class PatientDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "drugId", length = 50)
    private String drugId;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "quantity")
    private int quantity;
}

