insert into users (username, password, email, enabled) values ('admin', '$2a$10$2Gi3G9XaKalERoIa74OYruEHZyqSUqn10uSiOzk4PvOgL49vejna.','szakicool@gmail.com', true);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');


INSERT INTO profiles (user_id, first_name, last_name, phone, address, picture, description) VALUES
    (1, 'John', 'Smith', '12345', 'UK', 'user_pic_1.jpg', 'Hi, Im John');

