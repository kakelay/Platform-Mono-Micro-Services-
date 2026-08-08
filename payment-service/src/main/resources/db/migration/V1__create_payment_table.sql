CREATE TABLE IF NOT EXISTS payments (
    id UUID PRIMARY KEY,
    order_id UUID NOT NULL,
    account_id UUID NOT NULL,
    amount NUMERIC(19,4) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    method VARCHAR(100) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
