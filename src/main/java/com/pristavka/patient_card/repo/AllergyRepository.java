package com.pristavka.patient_card.repo;

import com.pristavka.patient_card.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy,Long>
{
}
