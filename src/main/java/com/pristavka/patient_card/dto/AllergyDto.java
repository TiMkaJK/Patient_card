package com.pristavka.patient_card.dto;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyDto
{
    @JsonRawValue
    private long IDDDDDD;
    private String NAMEEEEE;
    private String GROUPPPP;
}

