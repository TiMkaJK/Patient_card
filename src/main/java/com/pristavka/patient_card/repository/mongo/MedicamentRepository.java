package com.pristavka.patient_card.repository.mongo;

import com.pristavka.patient_card.model.mongo.Medicament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends MongoRepository<Medicament, String> {
}

