drop table if exists authorities;
drop table if exists profiles CASCADE;
drop table if exists users CASCADE;


create table users (
    user_id serial primary key,
    username varchar(50) not null unique,
    password varchar(60) not null,
    email text,
    premium_membership boolean DEFAULT false,
    role text DEFAULT 'USER',
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username),
    unique (username, authority)
);

CREATE TABLE profiles (
    user_id SERIAL PRIMARY KEY, /* user_id should be the PRIMARY KEY */
    first_name TEXT NULL,
    last_name TEXT NULL,
    phone INT NULL,
    address TEXT NULL,
    picture TEXT NULL,
    description TEXT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE
    /* Possible fields in the future:
        - short_introduction
        - spoken_languages
    */
);
