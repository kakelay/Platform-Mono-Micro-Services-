CREATE TABLE IF NOT EXISTS accounts (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    account_number VARCHAR(100) NOT NULL UNIQUE,
    account_type VARCHAR(100) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    balance NUMERIC(19,4) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
