CREATE DATABASE math;

\connect math

CREATE USER math;
ALTER USER math WITH ENCRYPTED PASSWORD '7Z5EEFkVLzYcU8hYkFk4nSVDjzpE4QmB';
GRANT ALL PRIVILEGES ON DATABASE math to math;

SET SESSION AUTHORIZATION math;

BEGIN;
DROP SCHEMA IF EXISTS math CASCADE;
CREATE SCHEMA IF NOT EXISTS math;

-- ------------------------------------------
-- Table math.course
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.course (
    name TEXT PRIMARY KEY,
    "desc" TEXT,
    image TEXT
);
-- ------------------------------------------
-- Table math.exercise
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.exercise (
    id SERIAL PRIMARY KEY,
    question TEXT NOT NULL UNIQUE,
    correct_answers TEXT NOT NULL,
    incorrect_answers TEXT,
    topic_name TEXT REFERENCES math.course(name),
    solution TEXT
);
-- ------------------------------------------
-- Table math.user
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.user (
    email VARCHAR(50) PRIMARY KEY,
    password TEXT NOT NULL,
    first_name VARCHAR(30)
);
-- ------------------------------------------
-- Table math.answer
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.answer (
    id SERIAL PRIMARY KEY,
    exercise_id INT  NOT NULL REFERENCES math.exercise(id),
    user_email TEXT  NOT NULL REFERENCES math.user(email),
    correct BOOL NOT NULL
);

-- TODO: unique index on exercise_id and user_email

END;
