package com.pristavka.patient_card.service;

import com.pristavka.patient_card.model.mongo.Drug;

import java.util.List;

public interface MedicamentService {

    List<Drug> getDrugs();

    void saveDrugs();
}
