package com.pristavka.patient_card.repository.mongo;

import com.pristavka.patient_card.model.mongo.AllergyMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergyMongoRepository extends MongoRepository<AllergyMongo, String> {
}
