CREATE TABLE IF NOT EXISTS notifications (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    type VARCHAR(100) NOT NULL,
    recipient VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL,
    message VARCHAR(1000) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
