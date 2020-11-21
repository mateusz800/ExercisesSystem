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
-- Table math.user
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.user (
    id SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password TEXT NOT NULL,
    first_name VARCHAR(30)
);
-- ------------------------------------------
-- Table math.course
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.course (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT,
    image TEXT
);
-- ------------------------------------------
-- Table math.exercise
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.course_author (
    course_id INT NOT NULL REFERENCES math.course(id),
    author_id INT NOT NULL REFERENCES math.user(id)
);
-- TODO: unique index on course_id and author_id
-- ------------------------------------------
-- Table math.exercise
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.exercise (
    id SERIAL PRIMARY KEY,
    question TEXT NOT NULL UNIQUE,
    correct_answers TEXT NOT NULL,
    incorrect_answers TEXT,
    course_id INT REFERENCES math.course(id) ON DELETE CASCADE,
    solution TEXT
);

-- ------------------------------------------
-- Table math.role
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.role (
    name VARCHAR(30) PRIMARY KEY,
    "desc" TEXT
);
-- ------------------------------------------
-- Table math.user_role
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.permissions (
    user_id INT NOT NULL REFERENCES math.user(id),
    role_name VARCHAR(30) NOT NULL REFERENCES math.role(name)
);
-- ------------------------------------------
-- Table math.answer
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.answer (
    id SERIAL PRIMARY KEY,
    exercise_id INT  NOT NULL REFERENCES math.exercise(id),
    user_id INT  NOT NULL REFERENCES math.user(id),
    correct BOOL NOT NULL
);

-- TODO: unique index on exercise_id and user_id

END;
