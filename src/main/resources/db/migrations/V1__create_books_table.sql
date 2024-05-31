-- V1__create_books_table.sql

CREATE TABLE books (
    id VARCHAR(36) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
);

INSERT INTO books VALUES(uuid(), 'Jurassic Park');
INSERT INTO books VALUES(uuid(), 'Station Eleven');
INSERT INTO books VALUES(uuid(), 'Less');