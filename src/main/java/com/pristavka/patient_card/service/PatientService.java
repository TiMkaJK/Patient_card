package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {

    Patient getPatient(Long id);

    Page<Patient> getPatients(Pageable pageable);

    List<Patient> findAllByUserEmail(String email);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Long id);
}
