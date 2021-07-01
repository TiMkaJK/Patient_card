package com.pristavka.patient_card.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupUtils {

    public static final String DRUG_NAME_URL = "https://list.essentialmeds.org/";

    public static Document getDocument(String url) {

        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Elements getDrugsname(Document document) {
        return document.getElementsByAttributeValue("class", "medicine-name");
    }
}

