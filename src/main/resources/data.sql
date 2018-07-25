INSERT INTO users (username, password, email, enabled, role) values ('admin', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'ADMIN');
INSERT INTO users (username, password, email, enabled, role) values ('user', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'USER');
INSERT INTO authorities (username, authority) values ('admin', 'ROLE_ADMIN');
INSERT INTO users (username, email, password, enabled) VALUES ('Golya Sandor', 'trolol@gmail.com', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.', true);
INSERT INTO users (username, email, password, enabled) VALUES ('Szlaszlo75', 'cactus9009@gmail.com', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.', true);
INSERT INTO users (username, email, password, activation_code) VALUES ('JohnSmith', 'bluepillow11@gmail.com', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.', 'giskg9H3Am');
INSERT INTO users (username, email, password, premium_membership, enabled) VALUES ('IHaveALotOfMoney', 'ritchwitch@gmail.com', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.', true, true);
INSERT INTO users (username, email, password, activation_code) VALUES ('Falloutboy', 'mousetrap34@gmail.com', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.', 'dG82KCjYiI');


INSERT INTO profiles (user_id, first_name, last_name, phone, address, picture, description) VALUES
    (1, 'John', 'Smith', '12345', 'UK', 'user_pic_1.jpg', 'Hi, Im John');

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

INSERT INTO works (contractor, category, description, sharing_date, due_date, price, currency_id, guarantee_value, guarantee_length_id, starting_date, bid, min_bidder_user_rate, bid_expire_date) VALUES
    (1, 'art', 'Family photos within 1 day!', '2018-07-01', '2018-07-30', 35, 1, 6, 3, '2018-07-03', false, null, null),
    (2, 'household','Wash1ng 5 dishes within 10 seconds! High quality with low price!', '2018-07-01', '2018-07-20', null, null, null, null, null, false, null, null),
    (2, 'gambling', 'Red goes here and black goes there...', '2018-07-01', '2018-07-30', null, null, null, null, null, true, 3, '2018-08-20')
;
