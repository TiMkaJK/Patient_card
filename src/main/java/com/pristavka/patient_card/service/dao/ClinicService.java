package com.pristavka.patient_card.service.dao;


import com.pristavka.patient_card.model.Clinic;

import java.util.List;

public interface ClinicService
{
    Clinic save(Clinic clinic);

    List<Clinic> findAll();

    void deleteById(long id);
}
