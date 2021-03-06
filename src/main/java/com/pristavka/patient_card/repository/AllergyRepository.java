package com.pristavka.patient_card.repository;

import com.pristavka.patient_card.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {

    @Query(value = "select * from allergy where `group` = ?1",
            nativeQuery = true)
    List<Allergy> findAllByGroup(String groupName);
}
