package com.pristavka.patient_card.model;

import com.pristavka.patient_card.model.enums.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 50)
    @Enumerated(value = EnumType.STRING)
    private UserStatus userStatus;

    @OneToMany(mappedBy = "status")
    private Set<User> users;
}

