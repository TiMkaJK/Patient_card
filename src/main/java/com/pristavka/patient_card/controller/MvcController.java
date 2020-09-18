package com.pristavka.patient_card.controller;


import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.impl.PatientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Slf4j
public class MvcController
{
    @Autowired
    private PatientServiceImpl patientService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin()
    {
        /*List<Patient> patients = this.patientService.findAllPatients();
        log.warn(patients.toString());*/

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        //model.addObject("patients", patients);
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user()
    {
        ModelAndView model = new ModelAndView();
        model.setViewName("user");
        return model;
    }
}