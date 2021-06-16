package com.pristavka.patient_card.repository;

import com.pristavka.patient_card.model.PatientDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDrugRepository extends JpaRepository<PatientDrug, Long> {
}
