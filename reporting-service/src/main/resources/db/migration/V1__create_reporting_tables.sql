CREATE TABLE report_transaction_summary (
    id BIGSERIAL PRIMARY KEY,
    transaction_id VARCHAR(100) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP
    WITH
        TIME ZONE DEFAULT now()
);

CREATE TABLE report_payment_summary (
    id BIGSERIAL PRIMARY KEY,
    payment_id VARCHAR(100) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP
    WITH
        TIME ZONE DEFAULT now()
);

CREATE TABLE report_order_summary (
    id BIGSERIAL PRIMARY KEY,
    order_id VARCHAR(100) NOT NULL,
    amount NUMERIC(19, 2) NOT NULL,
    created_at TIMESTAMP
    WITH
        TIME ZONE DEFAULT now()
);