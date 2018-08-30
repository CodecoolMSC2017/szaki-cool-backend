insert into users (username, password, email, enabled, role, activation_code) values ('admin', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true, 'ADMIN', null);
insert into users (username, password, email, enabled, role, activation_code) values ('user', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool-user@gmail.com', true, 'USER', null);
insert into users (username, password, email, enabled, role, activation_code) values ('ProSeller2018', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','proseller2018@gmail.com', true, 'USER', null);
insert into users (username, password, email, enabled, role, activation_code) values ('UnderShade', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','undershade@gmail.com', true, 'USER', null);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('user', 'ROLE_USER');


INSERT INTO profiles (user_id, first_name, last_name, phone, address, picture, description) VALUES
    (1, 'John', 'Smith', '12345', 'UK', 'default.png', 'Hi, I''m John'),
    (2, 'Jimmy', 'Smith', '46789', 'UK', 'default.png', 'Hi, I''m Jimmy'),
    (3, 'Paul', 'Brown', '447587828371', 'France', 'default.png', 'I''m a professional who can sell everything in a blink of an eye!'),
    (4, 'No', 'Name', '184358631', 'USA', 'default.png', 'You don''t wanna know...')
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

INSERT INTO works (contractor, title, category, description, sharing_date, due_date, price, currency_id, guarantee_value, guarantee_length_id, starting_date, bid, min_bidder_user_rate, bid_expire_date, notified) VALUES
    (1, 'title', 'art', 'Family photos within 1 day!', '2018-07-01 00:00:00', '2018-07-30 00:00:00', 35, 3, 6, 3, '2018-09-03 00:00:00', false, 2, null, false),
    (1, 'title', 'household','Washing 5 dishes within 10 seconds! High quality with low price!', '2018-07-01 00:00:00', '2018-09-20 00:00:00', 15, 3, 6, 3, null, false, 1, null, false),
    (1, 'title', 'gambling', 'Red goes here and black goes there...', '2018-07-01 00:00:00', '2018-09-30 00:00:00', 10, 3, 12, 3, null, true, 3, '2018-08-20 00:00:00',false),
    (2, 'Transcription 4 you', 'transcription', 'I will provide fast and flawless audio video transcription', '2018-09-01 00:00:00', '2018-07-30 00:00:00', 15, 3, 2, 1, '2018-07-03 00:00:00', false, 0, null, false),
    (2, 'Turbocharger upgrade', 'car mechanic','High valued service with the lowest price!', '2018-07-01 00:00:00', '2018-09-20 00:00:00', 50, 3, 1, 1, null, false, 0, null, false),

    (2, 'Clean dishes, easy life', 'household', 'I will do no matter how dirty...', '2018-07-01 00:00:00', '2018-10-03 00:00:00', 30, 3, 1, 1, null, true, 3, '2018-08-20 00:00:00', true),
    (3, 'Tattoo - Your skin, your story', 'art', 'I''m a professional tattoo artirts and also a graphic designer. With more than 6 years of experience and over 100 tattoos done by myself, i''m totally qualified to design originals tattoos for you. Feel free to contact me with no compromise. Hope we can work together! I will design the best tattoo art in the market, for the lowest price!', '2018-07-01 00:00:00', '2018-08-29 00:00:00', 80, 3, 1, 4, '2018-07-03 00:00:00', false, 5, null, false),
    (3, 'I will find online jobs for you', 'art', 'I will find 2 jobs that fits your need with my guidance how to do them.', '2018-07-01 00:00:00', '2018-11-01 00:00:00', 15, 3, 1, 1, '2018-07-03 00:00:00', false, 4, null, false),
    (3, 'I will give you a keto plan and recipes for 1 month', 'art', 'Everything in the Basic Plan + the Grocery List, wich will make your life way easier.', '2018-07-01 00:00:00', '2018-07-30 00:00:00', 5, 3, 1, 2, '2018-07-03 00:00:00', false, 10, null, false),
    (2, 'I will design a professional menu for you', 'art', '3 to 6 sided menu design, aprox A4, high resolution. Ready to print.', '2018-07-01 00:00:00', '2018-07-30 00:00:00', 800, 3, 1, 3, '2018-09-03 00:00:00', true, 7, '2018-07-03 00:00:00', true),

    (4, 'Weapons for hire!', 'art', 'Hire a PS-3000 tool, because the problem solved when it''s source is 6 feet under. Problem Solver 3000 is your perfect choice.', '2018-07-01 00:00:00', '2018-09-23 18:00:00', 1500, 3, 1, 1, '2018-09-30 00:00:00', true, 3, '2018-07-03 00:00:00', true)
;

INSERT INTO pictures (promoted, work_id, name) VALUES
    (true, 1, 'photographer.jpeg'),
    (true, 2, 'kecske.jpg'),
    (true, 3, 'railway.jpg'),
    (false, 1, 'paint2.jpg'),
    (false, 1, 'paint3.jpg'),
    (false, 1, 'paint4.jpg'),
    (true, 4, 'transcription.png'),
    (true, 5, 'turbocharger.jpg'),
    (true, 6, 'clean_dishes.jpg'),
    (true, 7, 'work-7-001.jpg'),
    (false, 7, 'work-7-002.jpg'),
    (false, 7, 'work-7-003.jpg'),
    (false, 7, 'work-7-004.jpg'),
    (true, 8, 'work-8-001.jpg'),
    (false, 8, 'work-8-002.jpg'),
    (false, 8, 'work-8-003.jpg'),
    (true, 9, 'work-9-001.jpg'),
    (false, 9, 'work-9-002.jpg'),
    (false, 9, 'work-9-003.jpg'),
    (true, 10, 'work-10-001.jpg'),
    (false, 10, 'work-10-002.jpg'),
    (false, 10, 'work-10-003.jpg'),
    (false, 10, 'work-10-004.jpg'),
    (true, 11, 'work-11-001.jpg'),
    (false, 11, 'work-11-002.jpg'),
    (false, 11, 'work-11-003.jpg'),
    (false, 11, 'work-11-004.jpg'),
    (false, 11, 'work-11-005.jpg')
;

INSERT INTO ratings (work_id, rating) VALUES
    (1, 4),
    (2, 4),
    (2, 3),
    (3, 5),
    (4, 5),
    (5, 2),
    (6, 3),
    (7, 1),
    (8, 2),
    (9, 5),
    (10, 2),
    (11, 1)
;

INSERT INTO favourite (user_id, work_id) VALUES
    (1, 7),
    (1, 6)
;


