CREATE TABLE IF NOT EXISTS roles (
    name VARCHAR(100) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    username VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    email VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id UUID NOT NULL,
    role_name VARCHAR(100) NOT NULL,
    PRIMARY KEY (user_id, role_name),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users (id),
    CONSTRAINT fk_role FOREIGN KEY (role_name) REFERENCES roles (name)
);

CREATE TABLE IF NOT EXISTS refresh_tokens (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    token TEXT NOT NULL UNIQUE,
    expires_at TIMESTAMP NOT NULL,
    CONSTRAINT fk_refresh_user FOREIGN KEY (user_id) REFERENCES users (id)
);
