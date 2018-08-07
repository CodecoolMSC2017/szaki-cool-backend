insert into users (username, password, email, enabled, role, activation_code) values ('admin', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'ADMIN', 'DGrHe9znXv');
insert into users (username, password, email, enabled, role, activation_code) values ('user', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'USER', 'DGrHe9znXb');
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user', 'ROLE_USER');


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

INSERT INTO pictures (promoted, work_id, name) VALUES
    (true, 1, 'kecske.jpg'),
    (true, 2, 'kecske.jpg')
;

