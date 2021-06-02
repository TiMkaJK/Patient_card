package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Patient;

import java.util.List;

public interface PatientService {

    Patient findById(long id);

    List<Patient> findAll();

    List<Patient> findAllByUserEmail(String email);

    Patient save(Patient patient);
}
