
CREATE TABLE coupons(
    id UUID PRIMARY KEY,
    code VARCHAR(100)  NOT NULL,
    discount INTEGER NOT NULL,
    valid TIMESTAMP NOT NULL,
    event_id UUID,
    created_at TIMESTAMP DEFAULT now(),
    FOREIGN KEY (event_id) REFERENCES events(id) ON DELETE CASCADE
);