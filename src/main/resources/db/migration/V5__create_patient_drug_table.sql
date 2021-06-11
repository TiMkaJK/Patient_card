create table patient_drug
(
    id            bigint not null auto_increment,
    patient_id    bigint not null,
    drug_id       varchar(255) not null,
    purchase_date timestamp default current_timestamp,
    quantity      int    not null,
    primary key (id)
);

alter table patient_drug
    add constraint fk_patientDrug_patient_Id
        foreign key (patient_id)
            references patient (id);