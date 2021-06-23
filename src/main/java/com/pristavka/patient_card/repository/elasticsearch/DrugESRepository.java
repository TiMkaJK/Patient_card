package com.pristavka.patient_card.repository.elasticsearch;

import com.pristavka.patient_card.model.elasticsearch.DrugES;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugESRepository extends ElasticsearchRepository<DrugES, String> {
}

