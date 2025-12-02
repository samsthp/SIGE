CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name TEXT NOT NULL,
                       email TEXT NOT NULL UNIQUE,
                       phone BIGINT,
                       password TEXT NOT NULL,
                       address TEXT NOT NULL,
                       register TEXT NOT NULL,
                       type enum_role NOT NULL
);
