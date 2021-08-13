CREATE TABLE allergy
(
    id      BIGINT      NOT NULL AUTO_INCREMENT,
    name    VARCHAR(50) NOT NULL,
    `group` VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE clinic
(
    id     BIGINT      NOT NULL AUTO_INCREMENT,
    name   VARCHAR(50) NOT NULL,
    number INTEGER     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE diagnosis
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE patient
(
    id             BIGINT      NOT NULL AUTO_INCREMENT,
    first_name     VARCHAR(40) NOT NULL,
    last_name      VARCHAR(50) NOT NULL,
    admission_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    floor          INTEGER     NOT NULL,
    ward           INTEGER     NOT NULL,
    clinic_id      BIGINT      NOT NULL,
    user_id        BIGINT      NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE patient_allergy
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    patient_id BIGINT NOT NULL,
    allergy_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE patient_diagnosis
(
    id           BIGINT NOT NULL AUTO_INCREMENT,
    patient_id   BIGINT NOT NULL,
    diagnosis_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE role
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE status
(
    id   BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(50),
    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    email      VARCHAR(255),
    password   VARCHAR(255),
    status_id  BIGINT NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    id      BIGINT NOT NULL AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE allergy
    ADD CONSTRAINT uk_allergy_name UNIQUE (name);

ALTER TABLE diagnosis
    ADD CONSTRAINT uk_allergy_name UNIQUE (name);

ALTER TABLE user
    ADD CONSTRAINT uk_user_email UNIQUE (email);

ALTER TABLE patient
    ADD CONSTRAINT fk_patient_clinic
        FOREIGN KEY (clinic_id)
            REFERENCES clinic (id);

ALTER TABLE patient
    ADD CONSTRAINT fk_patient_user
        FOREIGN KEY (user_id)
            REFERENCES user (id);

ALTER TABLE patient_allergy
    ADD CONSTRAINT fk_patientAllergy_allergy
        FOREIGN KEY (allergy_id)
            REFERENCES allergy (id);

ALTER TABLE patient_allergy
    ADD CONSTRAINT fk_patientAllergy_patient
        FOREIGN KEY (patient_id)
            REFERENCES patient (id);

ALTER TABLE patient_diagnosis
    ADD CONSTRAINT fk_patientDiagnosis_diagnosis
        FOREIGN KEY (diagnosis_id)
            REFERENCES diagnosis (id);

ALTER TABLE patient_diagnosis
    ADD CONSTRAINT fk_patientDiagnosis_patient
        FOREIGN KEY (patient_id)
            REFERENCES patient (id);

ALTER TABLE user
    ADD CONSTRAINT fk_user_status
        FOREIGN KEY (status_id)
            REFERENCES status (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_role
        FOREIGN KEY (role_id)
            REFERENCES role (id);

ALTER TABLE user_role
    ADD CONSTRAINT fk_userRole_user
        FOREIGN KEY (user_id)
            REFERENCES user (id);