package com.pristavka.patient_card.controller.mvc;


import com.pristavka.patient_card.model.jpa.Patient;
import com.pristavka.patient_card.service.jpa.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class PatientController {
    
    @GetMapping(path = "/add_patient")
    public String showPatientForm() {
        return "patient-form";
    }
}