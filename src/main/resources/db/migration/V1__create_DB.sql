create table if not exists allergy
(
    id   bigint      not null auto_increment,
    name varchar(50) not null unique,
    primary key (id)
) engine = InnoDB;

create table if not exists clinic
(
    id     bigint      not null auto_increment,
    name   varchar(50) not null,
    number integer     not null,
    primary key (id)
) engine = InnoDB;

create table if not exists diagnosis
(
    id   bigint       not null auto_increment,
    name varchar(100) not null,
    primary key (id)
) engine = InnoDB;

create table if not exists patient
(
    id             bigint      not null auto_increment,
    admission_date datetime(6) not null,
    first_name     varchar(40) not null,
    floor          integer     not null,
    last_name      varchar(50) not null,
    ward           integer     not null,
    clinic_id      bigint,
    primary key (id)
) engine = InnoDB;

create table if not exists clinic_patient
(
    clinic_id  bigint not null,
    patient_id bigint not null,
    primary key (clinic_id, patient_id)
) engine = InnoDB;

create table if not exists patient_allergies
(
    employees_id bigint not null,
    allergies_id bigint not null,
    primary key (employees_id, allergies_id)
) engine = InnoDB;

create table if not exists patient_diagnoses
(
    employees_id bigint not null,
    diagnoses_id bigint not null,
    primary key (employees_id, diagnoses_id)
) engine = InnoDB;

alter table allergy
    add constraint UK_jbyxnb3fyayfxfop1cchbopr unique (name);
alter table clinic_patient
    add constraint UK_pxx4il0ujrmommnoeox8ybblc unique (patient_id);
alter table diagnosis
    add constraint UK_cmhsif3dkafpbiu07vduk6ywn unique (name);
alter table clinic_patient
    add constraint FKbcl1w7lyllacucyli8rjpgebj foreign key (patient_id) references patient (id);
alter table clinic_patient
    add constraint FK3dv2nhaum0wg1aba5uuqkywpv foreign key (clinic_id) references clinic (id);
alter table patient
    add constraint FKrg813t22w4h0mx4bhgkwyvjl9 foreign key (clinic_id) references clinic (id);
alter table patient_allergies
    add constraint FKbfqu2ej9scb8y0nyk44ss3a8d foreign key (allergies_id) references allergy (id);
alter table patient_allergies
    add constraint FKjy1dluw36akxg7aw1drapr1a7 foreign key (employees_id) references patient (id);
alter table patient_diagnoses
    add constraint FKbo220kgk0tl3d8ors9kxt5jcd foreign key (diagnoses_id) references diagnosis (id);
alter table patient_diagnoses
    add constraint FK6r4c9ju4nbbdv8g67i0ov0tx9 foreign key (employees_id) references patient (id);