insert into role(name)
values ('ADMIN'),
       ('USER');

insert into status(name)
values ('ACTIVE'),
       ('BANNED');

insert into user(email, first_name, last_name, `password`, status_id)
values ('admin@imail.com', 'admin', 'admin', '$2y$12$L7pSJZc2q.NOicOmp73Qeum9EqcTxb1DSx9.fMajPjVZqWMlmPSyS', 1),
       ('user1@imail.com', 'user1', 'user1', '$2y$12$gsBXrs7n6yhO027Me0zE8O9bxncb3gGAfntg/yeW2lEBJCSXSHXYu', 1),
       ('user2@imail.com', 'user2', 'user2', '$2y$12$gsBXrs7n6yhO027Me0zE8O9bxncb3gGAfntg/yeW2lEBJCSXSHXYu', 1);

insert into user_roles(user_id, roles_id)
values (1, 1),
       (2, 2),
       (3, 2);

insert into diagnosis(name)
values ('COVID-19'),
       ('Flu');

insert into clinic(name, number)
values ('NY General', 5),
       ('LA Central Hospital', 23);

insert into patient(first_name, last_name, admission_date, floor, ward, clinic_id, user_id)
values ('Arnold', 'Schwarzenegger', '2020-09-14 09:28:52.000000', 5, 1, 1, 2),
       ('Sylvester', 'Stallone', '2020-09-10 12:15:52.000000', 5, 2, 1, 2),
       ('Bruce', 'Willis', '2020-09-05 10:10:52.000000', 25, 2, 2, 3);

insert into patient_allergies(patients_id, allergies_id)
values (1, 5),
       (2, 6),
       (3, 15);

insert into patient_diagnoses(patients_id, diagnoses_id)
values (1, 1),
       (2, 1),
       (3, 1)