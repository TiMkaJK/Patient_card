package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Clinic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClinicService {

    Page<Clinic> getClinics(Pageable pageable);

    Clinic getClinic(Long id);

    Clinic save(Clinic clinic);

    Clinic update(Clinic clinic);

    void delete(Long id);
}
