package com.pristavka.patient_card.repository;

import com.pristavka.patient_card.model.PatientDrug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDrugRepository extends JpaRepository<PatientDrug, Long> {
}
