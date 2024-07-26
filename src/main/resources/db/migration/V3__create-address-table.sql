CREATE TABLE address (
    id UUID PRIMARY KEY,
    city VARCHAR(255) NOT NULL,
    uf VARCHAR(5) NOT NULL,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(100) NOT NULL,
    event_id UUID,
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);