drop table if exists message_bindings;
drop table if exists messages;
drop table if exists pictures;
drop table if exists authorities;
drop table if exists profiles CASCADE;
DROP TABLE IF EXISTS works CASCADE;
DROP TABLE IF EXISTS guarantee_length;
DROP TABLE IF EXISTS currency;
drop table if exists users CASCADE;


create table users (
    user_id serial primary key,
    username varchar(50) not null unique,
    password varchar(60) not null,
    email text,
    premium_membership boolean DEFAULT false,
    role text DEFAULT 'USER',
    enabled boolean not null DEFAULT false,
    activation_code text
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

CREATE TABLE currency (
    id SERIAL PRIMARY KEY,
    currency TEXT NOT NULL
);


CREATE TABLE guarantee_length (
    id SERIAL PRIMARY KEY,
    guarantee_length TEXT NOT NULL
);

CREATE TABLE works (
    id SERIAL PRIMARY KEY,
    contractor INT NOT NULL, /* owner */
    description TEXT NOT NULL,
    category TEXT NOT NULL,
    sharing_date DATE NOT NULL,
    due_date DATE NOT NULL,
    price INT NULL,
    currency_id INT NULL,
    guarantee_value INT NULL,
    guarantee_length_id INT NULL,
    starting_date DATE NULL,
    bid BOOLEAN DEFAULT false,
    min_bidder_user_rate INT NULL,
    bid_expire_date DATE NULL,
    FOREIGN KEY (contractor) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (currency_id) REFERENCES currency(id),
    FOREIGN KEY (guarantee_length_id) REFERENCES guarantee_length(id)
    /* Possible fields in the future:
        - faq
    */
);

CREATE TABLE pictures (
    id SERIAL PRIMARY KEY,
    promoted BOOLEAN NOT NULL DEFAULT FALSE,
    work_id INTEGER,
    name TEXT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES works(id)
);

CREATE UNIQUE INDEX promoted_checker ON pictures (work_id) WHERE promoted = true;

CREATE TABLE messages (
    id SERIAL PRIMARY KEY,
    message TEXT,
    author_id INTEGER NOT NULL,
    send_date DATE,
    FOREIGN KEY (author_id) REFERENCES users(user_id) ON DELETE CASCADE
);

CREATE TABLE message_bindings (
    id SERIAL PRIMARY KEY,
    message_id INTEGER NOT NULL,
    target_id INTEGER NOT NULL,
    FOREIGN KEY (message_id) REFERENCES messages(id) ON DELETE CASCADE,
    FOREIGN KEY (target_id) REFERENCES users(user_id) ON DELETE CASCADE
);

