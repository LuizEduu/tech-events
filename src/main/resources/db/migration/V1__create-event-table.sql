CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE events(
    id UUID PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(250) NOT NULL,
    image_url VARCHAR(100) NOT NULL,
    event_url VARCHAR(100) NOT NULL,
    date TIMESTAMP NOT NULL,
    remote BOOLEAN NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);