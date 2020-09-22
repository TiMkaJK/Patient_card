package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.model.Role;
import com.pristavka.patient_card.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto
{
    private String email;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String lastName;

    private Set<Role> roles;

    private Status status;

    private Set<Patient> patients;
}

