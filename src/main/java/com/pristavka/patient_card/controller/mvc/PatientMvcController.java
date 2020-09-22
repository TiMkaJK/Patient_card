package com.pristavka.patient_card.controller.mvc;


import com.pristavka.patient_card.component.PatientProperties;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.impl.PatientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Locale;

@Controller
@Slf4j
public class PatientMvcController
{
    @Autowired
    private PatientServiceImpl patientService;

    @Autowired
    private PatientProperties properties;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin(/*Locale locale - if I want get current language what user selected*/)
    {
        List<Patient> patients = this.patientService.findAll();

        ModelAndView model = new ModelAndView();
        model.setViewName(properties.getAdmin());
        model.addObject(properties.getPatients(), patients);
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user(Authentication authentication)
    {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        List<Patient> patients = this.patientService.findAllByUserEmail(userDetails.getUsername());

        ModelAndView model = new ModelAndView();
        model.setViewName(properties.getUser());
        model.addObject(properties.getPatients(), patients);
        return model;
    }
}