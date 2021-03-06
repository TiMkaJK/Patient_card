insert into role(name)
values ('ADMIN'),
       ('USER');

insert into status(name)
values ('ACTIVE'),
       ('BANNED');

insert into user(email, first_name, last_name, `password`, status_id)
values ('admin@imail.com', 'Dmitriy', 'Pristavka', '$2y$12$L7pSJZc2q.NOicOmp73Qeum9EqcTxb1DSx9.fMajPjVZqWMlmPSyS', 1),
       ('user1@imail.com', 'Alexsandr', 'Bodruhin', '$2y$12$fV0MR9jD496lx3kH5JYWdeXwoGI8r9CPnZ3yf6FQG7WTFZXWcUP56', 1),
       ('user2@imail.com', 'Denis', 'Kovalevskiy', '$2y$12$fV0MR9jD496lx3kH5JYWdeXwoGI8r9CPnZ3yf6FQG7WTFZXWcUP56', 1);

insert into user_role(user_id, role_id)
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
       ('Bruce', 'Willis', '2020-09-05 10:10:52.000000', 25, 2, 2, 3),
       ('Петр', 'Васильев', '2020-10-01', 4, 6, 2, 3);

insert into patient_allergy(patient_id, allergy_id)
values (1, 5),
       (2, 6),
       (3, 15);

insert into patient_diagnosis(patient_id, diagnosis_id)
values (1, 1),
       (2, 1),
       (3, 1)