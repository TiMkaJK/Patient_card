insert into role(user_role)
values ('ADMIN'),
       ('USER');

insert into status(user_status)
values ('ACTIVE'),
       ('BANNED');

insert into user(email, first_name, last_name, `password`, role_id, status_id)
values ('admin@imail.com', 'admin', 'admin', '$2y$12$L7pSJZc2q.NOicOmp73Qeum9EqcTxb1DSx9.fMajPjVZqWMlmPSyS', 1, 1),
       ('user@imail.com', 'user', 'user', '$2y$12$gsBXrs7n6yhO027Me0zE8O9bxncb3gGAfntg/yeW2lEBJCSXSHXYu', 2, 2)

