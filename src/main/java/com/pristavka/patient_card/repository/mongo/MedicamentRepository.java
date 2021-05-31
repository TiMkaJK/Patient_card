package com.pristavka.patient_card.repository.mongo;

import com.pristavka.patient_card.model.mongo.Drug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentRepository extends MongoRepository<Drug, String> {
}

