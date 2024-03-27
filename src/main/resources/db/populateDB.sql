DELETE FROM orders;
DELETE FROM users;

INSERT INTO users (id, name, email)
VALUES (1, 'user1', 'email1'),
       (2, 'user2', 'email2'),
       (3, 'user3', 'email3');

INSERT INTO orders (id, user_id, description, status)
VALUES (1, 1, 'description1', 'ACCEPTED'),
       (2, 1, 'description2', 'ACCEPTED'),
       (3, 2, 'description3', 'ACCEPTED'),
       (4, 2, 'description4', 'ACCEPTED'),
       (5, 3, 'description5', 'ACCEPTED');



