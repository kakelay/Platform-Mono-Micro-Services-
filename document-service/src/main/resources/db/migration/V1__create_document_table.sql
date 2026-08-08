CREATE TABLE IF NOT EXISTS documents (
    id UUID PRIMARY KEY,
    owner_id UUID NOT NULL,
    entity_type VARCHAR(100) NOT NULL,
    entity_id UUID NOT NULL,
    document_type VARCHAR(100) NOT NULL,
    storage_url VARCHAR(1000) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL
);
