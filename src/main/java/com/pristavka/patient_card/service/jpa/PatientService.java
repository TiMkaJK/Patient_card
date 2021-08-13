package com.pristavka.patient_card.service.jpa;


import com.pristavka.patient_card.model.jpa.Patient;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PatientService {

    Patient getPatient(Long id) throws NotFoundException;

    Page<Patient> getPatients(Pageable pageable);

    List<Patient> findAllByUserEmail(String email);

    Patient save(Patient patient);

    Patient update(Patient patient);

    void delete(Long id);
}
