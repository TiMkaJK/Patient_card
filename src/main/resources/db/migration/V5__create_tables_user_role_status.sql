create table role
(
    id        bigint      not null auto_increment,
    user_role varchar(25) not null default 'USER',
    primary key (id)
) engine = InnoDB;

create table status
(
    id          bigint      not null auto_increment,
    user_status varchar(25) not null,
    primary key (id)
) engine = InnoDB;

create table user
(
    id         bigint              not null auto_increment,
    email      varchar(255) unique not null,
    first_name varchar(255)        not null,
    last_name  varchar(255)        not null,
    password   varchar(255)        not null,
    role_id    bigint,
    status_id  bigint,
    primary key (id)
) engine = InnoDB;

alter table user
    add constraint fk_user_role foreign key (role_id) references role (id);
alter table user
    add constraint fk_user_status foreign key (status_id) references status (id);
alter table user
    add constraint uk_user_email unique (email);