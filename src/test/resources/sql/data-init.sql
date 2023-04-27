INSERT INTO users (id, email, okta_id)
VALUES (1, 'kuba@mail.com', '123abc'),
       (2, 'jan@mail.com', '123abc'),
       (3, 'julia@mail.com', '123abc');

INSERT INTO meals (id, date, time, title, user_id)
VALUES (1, '2023-04-26', '09:00', 'Breakfast', 1),
       (2, '2023-04-26', '14:00', 'Cocktail', 1),
       (3, '2023-04-26', '17:00', 'Lunch', 1),
       (4, '2023-04-26', '20:30', 'Dinner', 1);

INSERT INTO meal_details (id, details, meal_id)
VALUES (1, '3 eggs', 1),
       (2, 'banana + yoghurt + spinach', 2),
       (3, 'chicken + rice + broccoli', 3),
       (4, 'salad + red pepper + onion + dressing', 4);
