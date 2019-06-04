INSERT INTO breed (id, name) VALUES (0, 'icebear');
INSERT INTO breed (id, name) VALUES (1, 'dog');
INSERT INTO breed (id, name) VALUES (2, 'tiger');
INSERT INTO breed (id, name) VALUES (3, 'shark');
INSERT INTO breed (id, name) VALUES (4, 'elg');

INSERT INTO person (id, first_name, last_name) VALUES (0, 'Tom', 'Adam');
INSERT INTO person (id, first_name, last_name) VALUES (1, 'Hans', 'Henrik');
INSERT INTO person (id, first_name, last_name) VALUES (2, 'Uten', 'Kjæledyrensen');

INSERT INTO pet(id, person_id, name, breed_id) VALUES (0, 0, 'Drino', 1);
INSERT INTO pet(id, person_id, name, breed_id) VALUES (1, 0, 'EatsYouOnLand', 2);
INSERT INTO pet(id, person_id, name, breed_id) VALUES (2, 0, 'EatsYouInWater', 3);

INSERT INTO pet(id, person_id, name, breed_id) VALUES (3, 1, 'KillsYouInCar', 4);
INSERT INTO pet(id, person_id, name, breed_id) VALUES (4, 1, 'EatsYouOnSvalbard', 0);