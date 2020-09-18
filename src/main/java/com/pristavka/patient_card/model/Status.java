package com.pristavka.patient_card.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Status
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",length = 50)
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "status")
    private Set<User> users;
}

