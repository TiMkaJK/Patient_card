create table allergy
(
    id      bigint      not null auto_increment,
    /*`group` varchar(50),*/
    name    varchar(50) not null,
    primary key (id)
) engine = InnoDB;

create table clinic
(
    id     bigint      not null auto_increment,
    name   varchar(50) not null,
    number integer     not null,
    primary key (id)
) engine = InnoDB;

create table clinic_patient
(
    clinic_id  bigint not null,
    patient_id bigint not null,
    primary key (clinic_id, patient_id)
) engine = InnoDB;

create table diagnosis
(
    id   bigint       not null auto_increment,
    name varchar(100) not null,
    primary key (id)
) engine = InnoDB;

create table patient
(
    id             bigint      not null auto_increment,
    first_name     varchar(40) not null,
    last_name      varchar(50) not null,
    admission_date datetime(6) not null,
    floor          integer     not null,
    ward           integer     not null,
    clinic_id      bigint,
    user_id        bigint,
    primary key (id)
) engine = InnoDB;

create table patient_allergies
(
    patients_id  bigint not null,
    allergies_id bigint not null,
    primary key (patients_id, allergies_id)
) engine = InnoDB;

create table patient_diagnoses
(
    patients_id  bigint not null,
    diagnoses_id bigint not null,
    primary key (patients_id, diagnoses_id)
) engine = InnoDB;

create table role
(
    id        bigint not null auto_increment,
    user_role varchar(255),
    primary key (id)
) engine = InnoDB;

create table status
(
    id          bigint not null auto_increment,
    user_status varchar(255),
    primary key (id)
) engine = InnoDB;

create table status_user
(
    status_id bigint not null,
    user_id   bigint not null,
    primary key (status_id, user_id)
) engine = InnoDB;

create table user
(
    id         bigint not null auto_increment,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    status_id  bigint,
    primary key (id)
) engine = InnoDB;

create table user_patient
(
    user_id    bigint not null,
    patient_id bigint not null,
    primary key (user_id, patient_id)
) engine = InnoDB;

create table user_roles
(
    user_id  bigint not null,
    roles_id bigint not null,
    primary key (user_id, roles_id)
) engine = InnoDB;

alter table user_patient
    add constraint UK_2h8xw31alj5f6fjudvlpq5lkb unique (patient_id);
alter table clinic_patient
    add constraint FKbcl1w7lyllacucyli8rjpgebj foreign key (patient_id) references patient (id);
alter table clinic_patient
    add constraint FK3dv2nhaum0wg1aba5uuqkywpv foreign key (clinic_id) references clinic (id);
alter table patient
    add constraint FKrg813t22w4h0mx4bhgkwyvjl9 foreign key (clinic_id) references clinic (id);
alter table patient
    add constraint FKp6ttmfrxo2ejiunew4ov805uc foreign key (user_id) references user (id);
alter table patient_allergies
    add constraint FKbfqu2ej9scb8y0nyk44ss3a8d foreign key (allergies_id) references allergy (id);
alter table patient_allergies
    add constraint FKs5gyqhlip35uagbc6yi9apy5a foreign key (patients_id) references patient (id);
alter table patient_diagnoses
    add constraint FKbo220kgk0tl3d8ors9kxt5jcd foreign key (diagnoses_id) references diagnosis (id);
alter table patient_diagnoses
    add constraint FKex5jftfpm8njmmvq72vi6ad0b foreign key (patients_id) references patient (id);
alter table status_user
    add constraint FKgk3vtxrb1fo2j28b4adwdg3di foreign key (user_id) references user (id);
alter table status_user
    add constraint FKibnemp37td4s0tfsiucwaqp5l foreign key (status_id) references status (id);
alter table user
    add constraint FKr62indkt0r2anb0m8hy5ldfpd foreign key (status_id) references status (id);
alter table user_patient
    add constraint FK2gmu6ggctd3trgb51nsemcsj foreign key (patient_id) references patient (id);
alter table user_patient
    add constraint FKrmf5kwqfrcst63jreog1vxvbc foreign key (user_id) references user (id);
alter table user_roles
    add constraint FKj9553ass9uctjrmh0gkqsmv0d foreign key (roles_id) references role (id);
alter table user_roles
    add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user (id);