insert into users (username, password, email, enabled, role, activation_code) values ('admin', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'ADMIN', null);
insert into users (username, password, email, enabled, role, activation_code) values ('user', '$2a$10$gks0yrt6re61gaPnpDm6LOXgqQ3QyBr5VZlZQJzF2FnGJ6fMCN0.G','szakicool-user@gmail.com', true, 'USER', null);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');


INSERT INTO profiles (user_id, first_name, last_name, phone, address, picture, description) VALUES
    (1, 'John', 'Smith', '12345', 'UK', 'default.png', 'Hi, Im John'),
    (2, 'Jimmy', 'Smith', '46789', 'UK', 'default.png', 'Hi, Im Jimmy')
;

INSERT INTO currency (currency) VALUES
    ('HUF'),
    ('EUR'),
    ('USD'),
    ('JPY')
;

INSERT INTO guarantee_length (guarantee_length) VALUES
    ('Day'),
    ('Week'),
    ('Month'),
    ('Year')
;

INSERT INTO works (contractor, title, category, description, sharing_date, due_date, price, currency_id, guarantee_value, guarantee_length_id, starting_date, bid, min_bidder_user_rate, bid_expire_date) VALUES
    (1, 'title', 'art', 'Family photos within 1 day!', '2018-07-01 00:00:00', '2018-07-30 00:00:00', 35, 1, 6, 3, '2018-07-03 00:00:00', false, null, null),
    (1, 'title', 'household','Wash1ng 5 dishes within 10 seconds! High quality with low price!', '2018-07-01 00:00:00', '2018-07-20 00:00:00', null, null, null, null, null, false, null, null),
    (1, 'title', 'gambling', 'Red goes here and black goes there...', '2018-07-01 00:00:00', '2018-07-30 00:00:00', null, null, null, null, null, true, 3, '2018-08-20 00:00:00'),
    (2, 'title', 'butcher', 'Little gippies go to Heaven', '2018-07-01 00:00:00', '2018-07-30 00:00:00', 15, 4, 2, 1, '2018-07-03 00:00:00', false, null, null),
    (2, 'Turbo charger upgrade', 'car mechanic','High valued service with the lowest price!', '2018-07-01 00:00:00', '2018-07-20 00:00:00', null, null, null, null, null, false, null, null),
    (2, 'Clean dishes, easy life', 'dish washer', 'I will do no matter how dirty...', '2018-07-01 00:00:00', '2018-07-30 00:00:00', null, null, null, null, null, true, 3, '2018-08-20 00:00:00')
;

INSERT INTO pictures (promoted, work_id, name) VALUES
    (true, 1, 'photographer.jpeg'),
    (true, 2, 'kecske.jpg'),
    (true, 3, 'kecske.jpg'),
    (false, 1, 'paint2.jpg'),
    (false, 1, 'paint3.jpg'),
    (false, 1, 'paint4.jpg'),
    (true, 4, 'paint4.jpg'),
    (true, 5, 'paint3.jpg'),
    (true, 6, 'paint2.jpg')
;

INSERT INTO ratings (work_id, rating) VALUES
    (1, 4),
    (2, 4),
    (2, 3)
;
