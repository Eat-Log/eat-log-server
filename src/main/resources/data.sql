INSERT INTO users (id, signed_in_user_name)
VALUES (1, 'kuba'),
       (2, 'jan');
--
-- INSERT INTO meals (id, date, time, title, user_id)
-- VALUES (1, '2023-04-26', '09:00', 'Breakfast', 1),
--        (2, '2023-04-26', '14:00', 'Cocktail', 1),
--        (3, '2023-04-26', '17:00', 'Lunch', 1),
--        (4, '2023-04-26', '20:30', 'Dinner', 1);

INSERT INTO meal_details (id, details)
VALUES (1, '3 eggs'),
       (2, 'banana + yoghurt + spinach'),
       (3, 'chicken + rice + broccoli'),
       (4, 'salad + red pepper + onion + dressing');

INSERT INTO meals (id, date, time, title, details_id, user_id)
VALUES (1, '2023-04-26', '09:00', 'Breakfast', 1, 1),
       (2, '2023-04-26', '14:00', 'Cocktail', 2, 1),
       (3, '2023-04-26', '17:00', 'Lunch', 3, 1),
       (4, '2023-04-26', '20:30', 'Dinner', 4, 1);


