package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto
{
    private UserStatus userStatus;
    private Set<User> users;
}

