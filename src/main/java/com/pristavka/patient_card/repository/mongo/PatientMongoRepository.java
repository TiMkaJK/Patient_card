package com.pristavka.patient_card.repository.mongo;

import com.pristavka.patient_card.model.mongo.PatientMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientMongoRepository extends MongoRepository<PatientMongo, String> {
}
