package com.pristavka.patient_card.controller.mvc;

import com.pristavka.patient_card.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrugController {

    @Autowired
    private DrugService drugService;

    @GetMapping(path = "/get-drug-list")
    public String drugList(/*Model model, Pageable pageable*/){

        /*Page<Drug> drugs = this.drugService.getDrugs(pageable);
        model.addAttribute("drugs", drugs.getContent());
        model.addAttribute("number", drugs.getNumber());
        model.addAttribute("totalPages", drugs.getTotalPages());
        model.addAttribute("totalElements", drugs.getTotalElements());*/

        return "drugs";
    }


}

