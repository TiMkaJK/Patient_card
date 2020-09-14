package com.pristavka.patient_card.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UserStatus userStatus;

    @OneToOne(mappedBy = "status")
    private User user;
}

