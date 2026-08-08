CREATE TABLE IF NOT EXISTS user_profiles (
    id UUID PRIMARY KEY,
    auth_user_id VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(150) NOT NULL,
    last_name VARCHAR(150) NOT NULL,
    email VARCHAR(254) NOT NULL,
    status VARCHAR(50) NOT NULL,
    preferences TEXT
);
