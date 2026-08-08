CREATE TABLE IF NOT EXISTS audit_events (
    id UUID PRIMARY KEY,
    action VARCHAR(100) NOT NULL,
    entity_type VARCHAR(100) NOT NULL,
    entity_id UUID NOT NULL,
    performed_by VARCHAR(255) NOT NULL,
    occurred_at TIMESTAMP NOT NULL,
    details VARCHAR(2000) NOT NULL
);
