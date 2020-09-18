package com.pristavka.patient_card.repo;

import com.pristavka.patient_card.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>
{
    @Query(value = "call getPatientByUserId(:userId)",
            nativeQuery = true)
    List<Patient> findAllByUserId(@Param("userId") long id);

    @Query(value ="call getAllPatients()",
            nativeQuery = true)
    List<Patient> findAllPatients();
}
