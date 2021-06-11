create table allergy
(
    id      bigint      not null auto_increment,
    `group` varchar(50),
    name    varchar(50) not null,
    primary key (id)
);

create table clinic
(
    id     bigint      not null auto_increment,
    name   varchar(50) not null,
    number integer     not null,
    primary key (id)
);

create table diagnosis
(
    id   bigint       not null auto_increment,
    name varchar(100) not null,
    primary key (id)
);

create table patient
(
    id             bigint      not null auto_increment,
    admission_date datetime default CURRENT_TIMESTAMP,
    first_name     varchar(40) not null,
    floor          integer     not null,
    last_name      varchar(50) not null,
    ward           integer     not null,
    clinic_id      bigint      not null,
    user_id        bigint      not null,
    primary key (id)
);


create table patient_allergy
(
    id bigint not null auto_increment,
    patient_id bigint not null,
    allergy_id bigint not null,
    primary key (id)
);

create table patient_diagnosis
(
    id bigint not null auto_increment,
    patient_id   bigint not null,
    diagnosis_id bigint not null,
    primary key (id)
);

create table role
(
    id   bigint not null auto_increment,
    name varchar(50),
    primary key (id)
);

create table status
(
    id   bigint not null auto_increment,
    name varchar(50),
    primary key (id)
);

create table user
(
    id         bigint not null auto_increment,
    email      varchar(255),
    first_name varchar(50),
    last_name  varchar(50),
    password   varchar(255),
    status_id  bigint not null,
    primary key (id)
);

create table user_role
(
    id bigint not null auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    primary key (id)
);

alter table allergy
    add constraint uk_allergy_name unique (name);

alter table diagnosis
    add constraint uk_allergy_name unique (name);

alter table user
    add constraint uk_user_email unique (email);

alter table patient
    add constraint fk_patient_clinic
        foreign key (clinic_id)
            references clinic (id);

alter table patient
    add constraint fk_patient_user
        foreign key (user_id)
            references user (id);

alter table patient_allergy
    add constraint fk_patientAllergy_allergy
        foreign key (allergy_id)
            references allergy (id);

alter table patient_allergy
    add constraint fk_patientAllergy_patient
        foreign key (patient_id)
            references patient (id);

alter table patient_diagnosis
    add constraint fk_patientDiagnosis_diagnosis
        foreign key (diagnosis_id)
            references diagnosis (id);

alter table patient_diagnosis
    add constraint fk_patientDiagnosis_patient
        foreign key (patient_id)
            references patient (id);

alter table user
    add constraint fk_user_status
        foreign key (status_id)
            references status (id);

alter table user_role
    add constraint fk_userRole_role
        foreign key (role_id)
            references role (id);

alter table user_role
    add constraint fk_userRole_user
        foreign key (user_id)
            references user (id);