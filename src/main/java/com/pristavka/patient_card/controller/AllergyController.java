package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.dto.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.service.AllergyServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AllergyController.ALLERGY_URL)
@Tag(name = "Allergy", description = "Provide manipulation with allergies")
@Slf4j
public class AllergyController
{
    public static final String ALLERGY_URL = "/allergies";

    private AllergyMapper mapper;

    @Operation(summary = "Return list of all allergies",
            description = "Return list of all allergies",
            tags = "allergy")
    @ApiResponses(
            value = @ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = @Content(
                            array = @ArraySchema(
                                    schema = @Schema(implementation = AllergyDto.class)
                            )
                    )
            )
    )
    @GetMapping
    public List<AllergyDto> findAllAllergies()
    {
        return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAll());
        //return this.allergyServiceImp.findAll();
    }

    @Autowired
    private AllergyServiceImp allergyServiceImp;

    @Operation(summary = "Add a new allergy",
            description = "Return list of all allergies",
            tags = "allergy")
    @ApiResponses(
            value = @ApiResponse(
                    responseCode = "200",
                    description = "successful operation",
                    content = @Content(
                            schema = @Schema(implementation = AllergyDto.class)
                    )
            )
    )
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Allergy saveAllergy(@RequestBody AllergyDto allergyDto)
    {
        return this.allergyServiceImp.save(mapper.allergyDtoToAllergy(allergyDto));
    }

    @Operation(summary = "Return pageable list of all allergies")
    @RequestMapping(value = "/listPageable", method = RequestMethod.GET)
    public Page<Allergy> allergiesPageable(Pageable pageable)
    {
        return this.allergyServiceImp.findAll(pageable);
    }

    @Operation(summary = "Return list of allergies by group")
    //@RequestMapping(value = "/{group}", method = RequestMethod.GET)
    @GetMapping("/{group}")
    public List<AllergyDto> findAllAllergiesByGroup(@RequestBody AllergyDto allergyDto)
    {
        return mapper.allergyToAllergyDtoList(this.allergyServiceImp.findAllByGroup(mapper.allergyDtoToAllergy(allergyDto)));
    }
}

