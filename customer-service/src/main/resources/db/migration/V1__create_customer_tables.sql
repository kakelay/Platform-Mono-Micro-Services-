CREATE TABLE IF NOT EXISTS customers (
    id UUID PRIMARY KEY,
    customer_type VARCHAR(100) NOT NULL,
    name VARCHAR(255) NOT NULL,
    status VARCHAR(100) NOT NULL,
    kyc_status VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS customer_addresses (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    address_type VARCHAR(100) NOT NULL,
    street VARCHAR(255) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    postal_code VARCHAR(50) NOT NULL,
    CONSTRAINT fk_customer_address_customer FOREIGN KEY (customer_id) REFERENCES customers (id)
);

CREATE TABLE IF NOT EXISTS customer_contacts (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL,
    contact_type VARCHAR(100) NOT NULL,
    value VARCHAR(255) NOT NULL,
    CONSTRAINT fk_customer_contact_customer FOREIGN KEY (customer_id) REFERENCES customers (id)
);
