CREATE TABLE artists (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         genre VARCHAR(100)
);

CREATE TABLE albums (
                        id BIGSERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        year INTEGER,
                        artist_id BIGINT REFERENCES artists(id)
);

CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE users_roles (
                             user_id BIGINT REFERENCES users(id),
                             role_id BIGINT REFERENCES roles(id),
                             PRIMARY KEY (user_id, role_id)
);

INSERT INTO roles (name) VALUES ('ROLE_USER'), ('ROLE_ADMIN');