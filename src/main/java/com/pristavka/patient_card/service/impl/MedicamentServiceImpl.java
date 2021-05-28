package com.pristavka.patient_card.service.impl;

import com.pristavka.patient_card.service.MedicamentService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Override
    public void saveMedicines() {
        getMedNames();
    }

    private List<String> getMedNames() {

        List<String> actorsNames = new ArrayList<>();
        String url = "http://pnd3.ru/patsientu/perechni-lekarstvennykh-preparatov/39-perechen-lekarstvennykh-preparatov";

        try {

            Document document = Jsoup.connect(url).get();
            Elements elements = document
                    .getElementsByAttributeValue("class", "uk-table uk-table-hover uk-table-condensed");
            log.info(elements + "");
            elements.forEach(a -> {
                //actorsNames.add(a.text());
                log.info(a.text());
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return actorsNames;
    }
}

