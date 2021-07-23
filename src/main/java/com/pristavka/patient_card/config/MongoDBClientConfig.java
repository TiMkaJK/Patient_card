package com.pristavka.patient_card.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.pristavka.patient_card.repository.mongo"})
public class MongoDBClientConfig {
}

