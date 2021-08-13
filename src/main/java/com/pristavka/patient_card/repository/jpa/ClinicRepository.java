package com.pristavka.patient_card.repository.jpa;

import com.pristavka.patient_card.model.jpa.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
