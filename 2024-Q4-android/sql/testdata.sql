-- Käyttäjätiedot
INSERT INTO users (username, hashedPassword, userMail) 
VALUES ('user1', 'hashed_pw1', 'user1@example.com'),
       ('user2', 'hashed_pw2', 'user2@example.com'),
       ('user3', 'hashed_pw3', 'user3@example.com'),
       ('user4', 'hashed_pw4', 'user4@example.com'),
       ('user5', 'hashed_pw5', 'user5@example.com'),
       ('user6', 'hashed_pw6', 'user6@example.com'),
       ('user7', 'hashed_pw7', 'user7@example.com'),
       ('user8', 'hashed_pw8', 'user8@example.com'),
       ('user9', 'hashed_pw9', 'user9@example.com'),
       ('user10', 'hashed_pw10', 'user10@example.com');

-- Koiraprofiilit
INSERT INTO dogs (userId, dogName, dogGender, dogBreed, dogPicture)
VALUES (1, 'Bella', 'Female', 'Golden Retriever', NULL),
       (1, 'Max', 'Male', NULL, 'https://example.com/max.jpg'),
       (2, 'Luna', 'Female', 'Beagle', NULL),
       (2, 'Charlie', 'Male', 'Poodle', NULL),
       (3, 'Rocky', 'Male', 'Labrador', 'https://example.com/rocky.jpg'),
       (4, 'Molly', 'Female', NULL, NULL),
       (5, 'Daisy', 'Female', 'Bulldog', NULL),
       (6, 'Bailey', 'Male', 'Boxer', 'https://example.com/bailey.jpg'),
       (7, 'Milo', 'Male', 'Dachshund', NULL),
       (8, 'Lucy', 'Female', NULL, NULL);

-- Koirapuistot
INSERT INTO parks (parkName, parkCity, parkAddress)
VALUES ('Central Park', 'Helsinki', 'Park Street 1'),
       ('Puistonkaari', 'Espoo', 'Kaari 5'),
       ('Koirapuisto Tampere', 'Tampere', 'Rantatie 10'),
       ('Vaasanpuisto', 'Vaasa', 'Keskustie 2'),
       ('Oulunpuisto', 'Oulu', 'Raitatie 6'),
       ('Jyväskylänpuisto', 'Jyväskylä', 'Mäntytie 7'),
       ('Kuopionpuisto', 'Kuopio', 'Lehtitie 3'),
       ('Lahdenpuisto', 'Lahti', 'Järventie 4'),
       ('Porinpuisto', 'Pori', 'Pelto 8'),
       ('Rovaniemenpuisto', 'Rovaniemi', 'Riekontie 9');

-- Tapaamiset
INSERT INTO meetings (parkId, userId, description, date, time)
VALUES (1, 1, 'Sunnuntain tapaaminen', '2024-10-23', '10:00'),
       (2, 1, 'Tiistain kävely', '2024-10-26', '12:00'),
       (3, 2, 'Lauantain leikkihetki', '2024-10-23', '14:00'),
       (4, 3, 'Koirien treenit', '2024-10-23', '16:00'),
       (5, 4, 'Iltatapaaminen', '2024-10-24', '18:00'),
       (6, 5, 'Aamukävely', '2024-10-24', '09:00'),
       (7, 6, 'Puiston leikkihetki', '2024-10-27', '10:30'),
       (8, 7, 'Lenkki puistossa', '2024-10-29', '11:00'),
       (9, 8, 'Koirapuiston ilta', '2024-10-25', '17:00'),
       (10, 9, 'Iltakävely', '2024-10-26', '19:00');

-- Osallistujat
INSERT INTO participants (meetingId, dogId)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (4, 6),
       (5, 7),
       (6, 8),
       (7, 9),
       (8, 10);

