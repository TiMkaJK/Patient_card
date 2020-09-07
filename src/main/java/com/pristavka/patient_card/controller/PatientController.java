package com.pristavka.patient_card.controller;

import com.pristavka.patient_card.dto.AllergyDto;
import com.pristavka.patient_card.dto.mapper.AllergyMapper;
import com.pristavka.patient_card.model.Allergy;
import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.Diagnosis;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.service.AllergyServiceImp;
import com.pristavka.patient_card.service.ClinicServiceImp;
import com.pristavka.patient_card.service.DiagnosisServiceImp;
import com.pristavka.patient_card.service.PatientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController
{
    private AllergyMapper mapper;

    @Autowired
    private PatientServiceImp patientService;

    @Autowired
    private ClinicServiceImp clinicService;

    @Autowired
    private DiagnosisServiceImp diagnosisService;

    @Autowired
    private AllergyServiceImp allergyService;

    @GetMapping("/")
    public List<Patient> findAllPatients()
    {
        return patientService.findAll();
    }

    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient)
    {
        return patientService.save(patient);
    }

    @GetMapping("/patient/{id}")
    public Patient findPatientById(@PathVariable long id)
    {
        return patientService.findById(id);
    }

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
    public List<AllergyDto> findAllAllergies()
    {
        return mapper.INSTANCE.allergyToAllergyDtoList(allergyService.findAll());
    }

    @RequestMapping(value = "/allergies/listPageable", method = RequestMethod.GET)
    public Page<Allergy> allergiesPageable(Pageable pageable)
    {
        return allergyService.findPaginated(pageable);
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
    /*@GetMapping("/allergies/page/{pageNo}")
    public List<Allergy> findPaginated(@PathVariable int pageNo)
    {
        int pageSize = 10;
        Page<Allergy> page = allergyService.findPaginated(pageNo, pageSize);
        return page.getContent();
    }*/
      @GetMapping("/allergies/group/{groupName}")
      public List<Allergy> findAllAllergiesByGroup(@PathVariable String groupName)
      {
          return allergyService.findAllByGroup(groupName);
      }
}

