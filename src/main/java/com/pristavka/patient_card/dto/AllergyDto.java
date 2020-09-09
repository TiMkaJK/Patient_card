package com.pristavka.patient_card.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyDto
{

    private long id;

    @Size(min = 1, max = 50)
    private String name;

    @Size(min = 1, max = 50)
    private String group;

}

