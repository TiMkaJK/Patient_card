package com.pristavka.patient_card.repository.jpa;

import com.pristavka.patient_card.model.jpa.PatientDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDrugRepository extends JpaRepository<PatientDrug, Long> {
}
