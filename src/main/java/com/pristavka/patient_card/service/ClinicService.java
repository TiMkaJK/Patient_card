package com.pristavka.patient_card.service;


import com.pristavka.patient_card.model.Clinic;

import java.util.List;

public interface ClinicService {

    Clinic save(String name);

    List<Clinic> findAll();

    void deleteById(long id);
}
