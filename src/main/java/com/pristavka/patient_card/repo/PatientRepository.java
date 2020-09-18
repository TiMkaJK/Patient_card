package com.pristavka.patient_card.repo;

import com.pristavka.patient_card.model.Patient;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.nio.file.Path;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    List<Patient> findAllByUserEmail(String email);
}
