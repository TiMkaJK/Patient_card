package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.model.enums.Contraindications;
import com.pristavka.patient_card.model.mongo.Coordinates;
import com.pristavka.patient_card.model.mongo.Drug;
import com.pristavka.patient_card.model.mongo.Manufacturer;
import com.pristavka.patient_card.repository.mongo.DrugRepository;
import com.pristavka.patient_card.service.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugRepository drugRepository;

    public static final int DATE_BOUND = 1830;
    public static final int LIST_BOUND = 5;

    @Override
    public Page<Drug> getDrugs(Pageable pageable) {
        return this.drugRepository.findAll(pageable);
    }

    @Override
    public void saveDrugs() {
        this.drugRepository.saveAll(createDrugs());
    }

    private List<Drug> createDrugs() {

        List<String> medsNames = getDrugNames();
        List<Coordinates> coordinates = getCoordinates();
        List<Manufacturer> manufacturers = getManufacturers();
        List<Set<String>> contraindications = getContraindications();
        LocalDate defaultDate = LocalDate.now();


        return medsNames
                .stream()
                .map(m -> {

                    Drug drug = new Drug();

                    drug.setName(m);
                    drug.setManufactureDate(defaultDate.minusDays(getRandomValue(DATE_BOUND)));
                    drug.setCoordinates(coordinates.get(getRandomValue(LIST_BOUND)));
                    drug.setManufacturer(manufacturers.get(getRandomValue(LIST_BOUND)));
                    drug.setContraindications(contraindications.get(getRandomValue(LIST_BOUND)));

                    return drug;
                })
                .collect(Collectors.toList());
    }

    private List<Set<String>> getContraindications() {

        List<Set<String>> contraindications = new ArrayList<>();

        contraindications.add(Set.of(
                Contraindications.GLAUCOMA.getCode(),
                Contraindications.AIDS.getCode(),
                Contraindications.AUTOIMMUNE_DISEASES.getCode())
        );

        contraindications.add(Set.of(
                Contraindications.HIGH_BLOOD_PRESSURE.getCode(),
                Contraindications.AUTOIMMUNE_DISEASES.getCode(),
                Contraindications.HYPERSENSITIVITY.getCode(),
                Contraindications.HEMOPHILIA.getCode()
        ));

        contraindications.add(Set.of(
                Contraindications.GASTRO_BLEEDING.getCode(),
                Contraindications.INTESTINAL_OBSTRUCTION.getCode(),
                Contraindications.INSOMNIA.getCode(),
                Contraindications.SICKNESS.getCode(),
                Contraindications.TUMOURS.getCode()
        ));

        contraindications.add(Set.of(
                Contraindications.AUTOIMMUNE_DISEASES.getCode(),
                Contraindications.SICKNESS.getCode()
        ));

        contraindications.add(Set.of(
                Contraindications.LOW_BLOOD_PRESSURE.getCode(),
                Contraindications.PREGNANCY.getCode(),
                Contraindications.INTESTINAL_OBSTRUCTION.getCode(),
                Contraindications.INSOMNIA.getCode()
        ));

        return contraindications;
    }

    private List<String> getDrugNames() {

        try {
            String url = "https://list.essentialmeds.org/";

            Document document = Jsoup.connect(url).get();
            Elements elements = document.getElementsByAttributeValue("class", "medicine-name");

            return elements
                    .stream()
                    .map(e -> e.select("span").text())
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private List<Coordinates> getCoordinates() {

        List<Coordinates> coordinates = new ArrayList<>();

        coordinates.add(new Coordinates("47.802552", "35.192623"));
        coordinates.add(new Coordinates("55.760986", "37.627656"));
        coordinates.add(new Coordinates("52.506742", "13.383456"));
        coordinates.add(new Coordinates("37.413752", "25.347023"));
        coordinates.add(new Coordinates("41.880664", "-87.674173"));

        return coordinates;
    }

    private List<Manufacturer> getManufacturers() {

        List<Manufacturer> manufacturers = new ArrayList<>();

        manufacturers.add(new Manufacturer("Лекхим", "Киев", "ул. Шота Руставели, 23", "01033"));
        manufacturers.add(new Manufacturer("Biopharma", "Киев", "ул. Николая Амосова, 12", "27063"));
        manufacturers.add(new Manufacturer("БАЙEР", "Киев", "ул. Верхний Вал 4-Б", "40710"));
        manufacturers.add(new Manufacturer("Дарница", "Киев", "ул. Бориспольская, 13", "02093"));
        manufacturers.add(new Manufacturer("Фармак", "Киев", "ул. Кирилловская, 63", "04080"));

        return manufacturers;
    }

    private int getRandomValue(int bound) {
        return new Random().nextInt(bound);
    }
}

