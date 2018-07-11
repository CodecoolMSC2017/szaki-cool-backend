drop table if exists greeting;
create table greeting (
    id serial primary key,
    lang varchar(2) not null,
    "text" text
);
