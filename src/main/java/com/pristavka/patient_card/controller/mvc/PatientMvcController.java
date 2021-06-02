package com.pristavka.patient_card.controller.mvc;


import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class PatientMvcController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(path = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {

        List<Patient> patients = this.patientService.findAll();

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        model.addObject("patients", patients);

        return model;
    }

    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView user(Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<Patient> patients = this.patientService.findAllByUserEmail(userDetails.getUsername());

        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        model.addObject("patients", patients);

        return model;
    }

    @GetMapping(path = "/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";
    }

    @GetMapping(path = "/patient_form")
    public String showPatientForm() {
        return "patient_form";
    }
}