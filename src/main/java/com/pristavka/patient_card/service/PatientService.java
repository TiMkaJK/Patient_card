package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Patient;

import java.util.List;

public interface PatientService {

    Patient getPatient(Long id);

    List<Patient> getPatients();

    List<Patient> findAllByUserEmail(String email);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Long id);
}
