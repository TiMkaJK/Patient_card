package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Clinic;

import java.util.List;

public interface ClinicService {

    List<Clinic> getClinics();

    Clinic getClinic(Long id);

    Clinic save(Clinic clinic);

    Clinic update(Clinic clinic);

    void delete(Long id);
}
