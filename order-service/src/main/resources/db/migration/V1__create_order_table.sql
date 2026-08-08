CREATE TABLE IF NOT EXISTS orders (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    account_id UUID NOT NULL,
    total_amount NUMERIC(19,4) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    status VARCHAR(50) NOT NULL,
    description VARCHAR(500) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
