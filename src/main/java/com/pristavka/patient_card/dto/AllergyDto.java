package com.pristavka.patient_card.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllergyDto {

    @Schema(
            description = "Allergy unique identifier id",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "name of the allergen",
            example = "watermelon"
    )
    @Size(min = 1, max = 50)
    private String name;

    @Schema(
            description = "common group of allergens of the same type",
            example = "food"
    )
    @Size(min = 1, max = 50)
    private String group;
}

