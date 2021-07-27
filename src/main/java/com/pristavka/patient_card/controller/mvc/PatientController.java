package com.pristavka.patient_card.controller.mvc;


import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(path = "/admin")
    public ModelAndView admin(Pageable pageable) {

        List<Patient> patients = this.patientService.getPatients(pageable).getContent();

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        model.addObject("patients", patients);

        return model;
    }

    @GetMapping(path = "/user")
    public ModelAndView user(Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<Patient> patients = this.patientService.findAllByUserEmail(userDetails.getUsername());

        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        model.addObject("patients", patients);

        return model;
    }

    /*@GetMapping(path = "/registration")
    public String showRegistrationForm() {
        return "registration";
    }*/

    @GetMapping(path = "/add_patient")
    public String showPatientForm() {
        return "patient-form";
    }
}