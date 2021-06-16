package com.pristavka.patient_card.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Contraindications {

    HIGH_BLOOD_PRESSURE("High Blood Pressure"),
    LOW_BLOOD_PRESSURE("Low Blood Pressure"),
    SICKNESS("Sickness"),
    PREGNANCY("Pregnancy"),
    AUTOIMMUNE_DISEASES("Autoimmune Diseases"),
    HYPERSENSITIVITY("Hypersensitivity"),
    AIDS("AIDS or HIV infection"),
    TUMOURS("Tumours"),
    IMMUNOSUPPRESSION("Immunosuppression"),
    INTESTINAL_OBSTRUCTION("Intestinal Obstruction"),
    GASTRO_BLEEDING("Gastric and intestinal bleeding"),
    HEMOPHILIA("Hemophilia"),
    EXCITABILITY("Increased Excitability"),
    INSOMNIA("Insomnia"),
    GLAUCOMA("Glaucoma");

    private final String code;

    /*Contraindications(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }*/
}
