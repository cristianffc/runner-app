create table if not exists users (
    id number not null,
    username varchar(256),
    password varchar(256),
    enabled char(1)
);

create table if not exists authorities (
    id number not null,
    username varchar(256),
    authority varchar(256)
);