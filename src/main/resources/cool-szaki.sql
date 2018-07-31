DROP TABLE IF EXISTS ratings;
DROP TABLE IF EXISTS bids;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS work_images;
DROP TABLE IF EXISTS works;
DROP TABLE IF EXISTS guarantee_length;
DROP TABLE IF EXISTS currency;
DROP TABLE IF EXISTS user_skills;
DROP TABLE IF EXISTS professions;
DROP TABLE IF EXISTS private_messages;
DROP TABLE IF EXISTS profiles;
DROP TABLE IF EXISTS users;


CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL CHECK (email <> ''),
    password TEXT NOT NULL,
    role TEXT NOT NULL DEFAULT 'USER',
    premium_membership BOOLEAN DEFAULT false,
    registration_date DATE NOT NULL
);

CREATE TABLE profiles (
    user_id SERIAL PRIMARY KEY, /* user_id should be the PRIMARY KEY */
    first_name TEXT NULL,
    last_name TEXT NULL,
    phone INT NULL,
    address TEXT NULL,
    picture TEXT NULL,
    description TEXT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
    /* Possible fields in the future:
        - short_introduction
        - spoken_languages
    */
);

CREATE TABLE private_messages (
    id SERIAL PRIMARY KEY,
    time DATE NOT NULL,
    from_user_id INT NOT NULL,
    to_user_id INT NOT NULL,
    message TEXT NOT NULL
    /* Possible fields in the future:
        - order_requirements (like a hint to the message sender)
    */
);

CREATE TABLE professions (
    id SERIAL PRIMARY KEY,
    profession TEXT UNIQUE NOT NULL
);

CREATE TABLE user_skills (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    profession_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (profession_id) REFERENCES professions(id) ON DELETE CASCADE
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
    title TEXT NOT NULL,
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
    FOREIGN KEY (contractor) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (currency_id) REFERENCES currency(id),
    FOREIGN KEY (guarantee_length_id) REFERENCES guarantee_length(id)
    /* Possible fields in the future:
        - faq
    */
);

CREATE TABLE work_images (
    id SERIAL PRIMARY KEY,
    work_id INT NOT NULL, /* work_id should be the PRIMARY KEY */
    image TEXT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE CASCADE
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY, /* work_id should be the PRIMARY KEY */
    work_id INT NOT NULL,
    customer INT NOT NULL,
    date_completed DATE NULL,
    FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE CASCADE
);

CREATE TABLE bids (
    id SERIAL PRIMARY KEY, /* work_id should be the PRIMARY KEY */
    work_id INT NOT NULL,
    user_id INT NOT NULL,
    value INT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE ratings (
    id SERIAL PRIMARY KEY,
    work_id INT NOT NULL,
    rating INT NOT NULL,
    give_id INT NOT NULL,
    gets_id INT NOT NULL,
    FOREIGN KEY (work_id) REFERENCES works(id) ON DELETE CASCADE
);
