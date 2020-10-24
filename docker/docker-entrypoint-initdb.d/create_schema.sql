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

END;
