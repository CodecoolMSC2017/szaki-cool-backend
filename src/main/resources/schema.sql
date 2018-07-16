DROP TABLE IF EXISTS users;

CREATE TABLE users (
id serial,
name text NOT NULL UNIQUE,
email text NOT NULL UNIQUE,
password text NOT NULL,
role text NOT NULL DEFAULT 'USER',
premium_status boolean NOT NULL DEFAULT false,
PRIMARY KEY (id)
);
