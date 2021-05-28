package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.Clinic;
import com.pristavka.patient_card.model.Patient;
import com.pristavka.patient_card.model.User;
import com.pristavka.patient_card.model.mongo.PatientMongo;
import com.pristavka.patient_card.repository.PatientRepository;
import com.pristavka.patient_card.repository.mongo.PatientMongoRepository;
import com.pristavka.patient_card.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientMongoRepository patientMongoRepository;

    @Override
    public Patient findById(long id) {
        return this.patientRepository.findById(id).orElseThrow(() -> new NotFoundException("patient not found"));
    }

    @Override
    public List<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    @Override
    public List<Patient> findAllByUserEmail(String email) {
        return this.patientRepository.findAllByUserEmail(email);
    }

    @Override
    public Patient save(Patient patient) {
        return this.patientRepository.save(patient);
    }

    @Override
    public void fillPatients() {
        this.patientRepository.saveAll(getPatients());
    }

    @Override
    public void saveAllPatientsToMongoDb() {
        List<Patient> patients = this.patientRepository.findAll();

        PatientMongo patient = new PatientMongo();
        patient.setId(String.valueOf(patients.get(0).getId()));
        patient.setFirstName(patients.get(0).getFirstName());
        patient.setLastName(patients.get(0).getLastName());
        patient.setUser(patients.get(0).getUser());
        patient.setClinic(patients.get(0).getClinic());
        patient.setFloor(String.valueOf(patients.get(0).getFloor()));
        patient.setWard(String.valueOf(patients.get(0).getWard()));

        this.patientMongoRepository.save(patient);
    }


    private List<String> getActorNames() {

        List<String> actorsNames = new ArrayList<>();
        String[] siteUrls = {"https://www.the-numbers.com/box-office-star-records/domestic/lifetime-acting/top-grossing-leading-stars",
                "https://www.the-numbers.com/box-office-star-records/domestic/lifetime-acting/top-grossing-leading-stars/101",
                "https://www.the-numbers.com/box-office-star-records/domestic/lifetime-acting/top-grossing-leading-stars/201",
                "https://www.the-numbers.com/box-office-star-records/domestic/lifetime-acting/top-grossing-leading-stars/301",
                "https://www.the-numbers.com/box-office-star-records/domestic/lifetime-acting/top-grossing-leading-stars/401",
        };

        for (int i = 0; i < siteUrls.length; i++) {

            try {

                Document document = Jsoup.connect(siteUrls[i]).get();
                Elements elements = document.getElementsByAttributeValue("id", "page_filling_chart").select("tr > td > b > a");

                elements.forEach(a -> {
                    actorsNames.add(a.text());
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return actorsNames;
    }



    private List<Patient> getPatients() {
        List<String> actorsNames = getActorNames();
        List<Patient> patients = new ArrayList<>();
        LocalDateTime localDateTime = LocalDateTime.now();

        actorsNames.forEach(a -> {
            String[] name = a.split(" ");

            if (Objects.equals(name.length, 2)) {
                Patient patient = new Patient();
                Clinic clinic = new Clinic();
                clinic.setId(2);
                User user = new User();
                user.setId(2);

                patient.setFirstName(name[0]);
                patient.setLastName(name[1]);
                patient.setFloor(2);
                patient.setClinic(clinic);
                patient.setWard(4);
                patient.setUser(user);
                patient.setAdmissionDate(localDateTime);
                patients.add(patient);
            }
        });

        return patients;
    }
}

