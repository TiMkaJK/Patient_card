CREATE TABLE patient_drug
(
    id            BIGINT       NOT NULL AUTO_INCREMENT,
    patient_id    BIGINT       NOT NULL,
    drug_id       VARCHAR(255) NOT NULL,
    purchase_date TIMESTAMP DEFAULT current_timestamp,
    quantity      INT          NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE patient_drug
    ADD CONSTRAINT fk_patientDrug_patient_Id
        FOREIGN KEY (patient_id)
            REFERENCES patient (id);
