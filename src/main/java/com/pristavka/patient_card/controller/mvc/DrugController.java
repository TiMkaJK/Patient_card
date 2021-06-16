package com.pristavka.patient_card.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DrugController {

    @GetMapping(path = "/drugs")
    public String drugList(){
        return "drugs";
    }
}

