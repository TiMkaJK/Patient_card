package com.pristavka.patient_card.service.elasticsearch.impl;

import com.pristavka.patient_card.model.elasticsearch.DrugES;
import com.pristavka.patient_card.repository.elasticsearch.DrugESRepository;
import com.pristavka.patient_card.service.elasticsearch.DrugESService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugESServiceImpl implements DrugESService {

    @Autowired
    private DrugESRepository drugESRepository;

    public Iterable<DrugES> findAll() {
        return drugESRepository.findAll();
    }

    public void test() {

    }
}

