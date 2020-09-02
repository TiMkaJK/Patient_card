package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.AllergyServiceImp;
import com.pristavka.patient_card.service.ClinicServiceImp;
import com.pristavka.patient_card.service.DiagnosisServiceImp;
import com.pristavka.patient_card.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController
{
    @Autowired
    private PatientServiceImp patientService;

    @Autowired
    private ClinicServiceImp clinicService;

    @Autowired
    private DiagnosisServiceImp diagnosisService;

    @Autowired
    private AllergyServiceImp allergyService;

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient)
    {
        return patientService.save(patient);
    }

    @GetMapping("/")
    public List<Patient> findAllPatients()
    {
        return patientService.findAll();
    }

    @GetMapping("/patient/{id}")
    public Patient findPatientById(@PathVariable long id)
    {
        return patientService.findById(id);
    }

    /*@PostMapping("/addDiagnosis")
    public Diagnosis addDiagnosis(@RequestBody Diagnosis diagnosis)
    {
        return diagnosisService.save(diagnosis);
    }

    @PostMapping("/addClinic")
    public Clinic addClinic(@RequestBody Clinic clinic)
    {
        return clinicService.save(clinic);
    }

    @PostMapping("/addAllergy")
    public Allergy addAllergy(@RequestBody Allergy allergy)
    {
        return allergyService.save(allergy);
    }*/

    @PostMapping("/addDiagnosis")
    public Diagnosis addDiagnosis(@RequestBody String name)
    {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(name);
        return diagnosisService.save(diagnosis);
    }

    @PostMapping("/addClinic")
    public Clinic addClinic(@RequestBody String name)
    {
        Clinic clinic = new Clinic();
        clinic.setName(name);
        return clinicService.save(clinic);
    }

    @PostMapping("/addAllergy/{name}")
    public Allergy addAllergy(@PathVariable String name)
    {
        Allergy allergy = new Allergy();
        allergy.setName(name);
        return allergyService.save(allergy);
    }

    @GetMapping("/allergies")
    public List<Allergy> findAllAllergies()
    {
        return allergyService.findAll();
    }
}

