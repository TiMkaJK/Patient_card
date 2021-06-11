package com.pristavka.patient_card.dto;

import com.pristavka.patient_card.model.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusDto {

    private Long id;
    private UserStatus userStatus;
    //private Set<User> users = new HashSet<>();
}

