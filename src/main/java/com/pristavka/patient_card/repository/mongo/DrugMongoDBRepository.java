package com.pristavka.patient_card.repository.mongo;

import com.pristavka.patient_card.model.mongo.Drug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface DrugMongoDBRepository extends MongoRepository<Drug, String> {

    List<Drug> findDrugsByIdIn(List<String> ids);
}
