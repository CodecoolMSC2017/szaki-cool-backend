INSERT INTO users (name, email, password, role, premium_membership, registration_date)
VALUES ('user1', '1@user.com', 'a', 'ADMIN', true, '2018-07-01');
INSERT INTO users (name, email, password, role, registration_date)
VALUES ('user2', '2@user.com', 'a', 'USER', '2018-07-01');
INSERT INTO users (name, email, password, role, premium_membership, registration_date)
VALUES ('user3', '3@user.com', 'a', 'USER', true, '2018-03-01');
INSERT INTO users (name, email, password, registration_date) VALUES ('Golya Sandor', 'trolol@gmail.com', '123456', '2018-03-01');
INSERT INTO users (name, email, password, registration_date) VALUES ('Szlaszlo75', 'cactus9009@gmail.com', 'asdf', '2010-07-01');
INSERT INTO users (name, email, password, registration_date) VALUES ('JohnSmith', 'bluepillow11@gmail.com', 'szezamtarulj', '2016-10-03');
INSERT INTO users (name, email, password, premium_membership, registration_date) VALUES ('IHaveALotOfMoney', 'ritchwitch@gmail.com', '$$$$$$', true, '2013-05-11');
INSERT INTO users (name, email, password, role, registration_date) VALUES ('a', 'admin@coolszaki.hu', 'a', 'ADMIN', '2014-07-28');
INSERT INTO users (name, email, password, registration_date) VALUES ('b', 'testuser@gmail.com', 'b', '2012-12-01');
INSERT INTO users (name, email, password, registration_date) VALUES ('Falloutboy', 'mousetrap34@gmail.com', 'banana', '2018-03-15');




INSERT INTO profiles (user_id, first_name, last_name, phone, address, picture, description) VALUES
    (1, 'John', 'Smith', '12345', 'UK', 'user_pic_1.jpg', 'Hi, Im John'),
    (2, 'Charlie', 'Brown', null, 'USA', 'user_pic_2.jpg', 'I konow you know me'),
    (3, 'Pamela', 'Taylor', '56789', 'USA', null, null)
;

INSERT INTO private_messages (time, from_user_id, to_user_id, message) VALUES
    ('2018-07-01', 1, 2, 'Hi, Im John'),
    ('2018-07-01', 1, 2, 'How are you today?'),
    ('2018-07-01', 1, 2, 'Hmm?'),
    ('2018-07-01', 2, 1, 'Sorry for my late reply'),
    ('2018-07-02', 2, 1, 'Im fed up...'),
    ('2018-07-02', 1, 2, 'What happened?')
;

INSERT INTO professions (profession) VALUES
    ('art photographer'),
    ('butcher'),
    ('car mechanic'),
    ('dish washer'),
    ('electrician'),
    ('farmer')
;

INSERT INTO user_skills (user_id, profession_id) VALUES
    (1,1),
    (1,2),
    (1,3),
    (2,3),
    (2,4),
    (2,5)
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

INSERT INTO works (contractor, description, sharing_date, due_date, price, currency_id, guarantee_value, guarantee_length_id, starting_date, bid, min_bidder_user_rate, bid_expire_date) VALUES
    (1, 'Family photos within 1 day!', '2018-07-01', '2018-07-30', 35, 1, 6, 3, '2018-07-03', false, null, null),
    (2, 'Wash1ng 5 dishes within 10 seconds! High quality with low price!', '2018-07-01', '2018-07-20', null, null, null, null, null, false, null, null),
    (2, 'Red goes here and black goes there...', '2018-07-01', '2018-07-30', null, null, null, null, null, true, 3, '2018-08-20')
;

INSERT INTO work_images (work_id, image) VALUES
    (1, 'family_1.jpg'),
    (1, 'family_2.jpg')
;

INSERT INTO orders (work_id, customer, date_completed) VALUES
    (1, 3, '2018-07-05'),
    (2, 3, null)
;

INSERT INTO ratings (work_id, rating, give_id, gets_id) VALUES
    (1, 4, 3, 1),
    (1, 4, 1, 3)
;
