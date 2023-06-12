create table if not exists test(
    id serial primary key,
    "name" varchar(32) not null unique
);