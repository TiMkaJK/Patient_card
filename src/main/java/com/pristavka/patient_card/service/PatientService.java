package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Patient;

import java.util.List;

public interface PatientService
{
    Patient findById(long id);

    List<Patient> findAllPatients();

    Patient save(Patient patient);

    List<Patient> findAllByUserId(int id);
}
