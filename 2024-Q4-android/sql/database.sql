-- Active: 1710485472561@@127.0.0.1@5432@postgres

DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS dogs CASCADE;
DROP TABLE IF EXISTS parks CASCADE;
DROP TABLE IF EXISTS meetings CASCADE;
DROP TABLE IF EXISTS participants CASCADE;

CREATE TABLE users (
    userId SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
	hashedPassword VARCHAR(255) NOT NULL,
    userMail VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE dogs (
    dogId SERIAL PRIMARY KEY,
    userId INT REFERENCES Users(userId) ON DELETE CASCADE,
    dogName VARCHAR(250) NOT NULL,
    dogGender VARCHAR(10) NOT NULL,
    dogBreed VARCHAR(250),
    dogPicture TEXT
);

CREATE TABLE parks (
    parkId SERIAL PRIMARY KEY,
    parkName VARCHAR(250) NOT NULL,
    parkCity VARCHAR(250) NOT NULL,
    parkAddress VARCHAR(250) NOT NULL
);

CREATE TABLE meetings (
    meetingId SERIAL PRIMARY KEY,
    parkId INT REFERENCES Parks(parkId) ON DELETE CASCADE,
    userId INT REFERENCES Users(userId) ON DELETE CASCADE,
    description TEXT,
    date DATE NOT NULL,
    time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (parkId, date, time)
);

CREATE TABLE participants (
    participantId SERIAL PRIMARY KEY,
    meetingId INT REFERENCES Meetings(meetingId) ON DELETE CASCADE,
    dogId INT REFERENCES Dogs(dogId) ON DELETE CASCADE,
    UNIQUE (meetingId, dogId)
);

--Rajoitus pitää olla siis käyttäjäkohtaisesti eli enintään 5 tapaamista per käyttäjä per päivä
--SELECT COUNT(*) 
--FROM meetings 
--WHERE date = '2024-10-22' 
--AND park_id = 1;
