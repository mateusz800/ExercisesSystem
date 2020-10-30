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
-- Table math.topic
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.topic (
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
    correct_answer TEXT NOT NULL,
    other_answers JSON,
    topic_name TEXT REFERENCES math.topic(name),
    solution TEXT
);
-- ------------------------------------------
-- Table math.user
-- ------------------------------------------
CREATE TABLE IF NOT EXISTS math.user (
    email VARCHAR(50) PRIMARY KEY,
    password VARCHAR(30) NOT NULL,
    first_name VARCHAR(30)
);

END;
