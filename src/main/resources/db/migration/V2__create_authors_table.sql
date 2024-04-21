-- V2__create_authors_table.sql

CREATE TABLE authors (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

INSERT INTO authors VALUES(uuid(), 'Michael Crichton');
INSERT INTO authors VALUES(uuid(), 'Emily St. John Mandel');
INSERT INTO authors VALUES(uuid(), 'Andrew Sean Greer');

CREATE TABLE book_authors (
    book_id VARCHAR(36),
    author_id VARCHAR(36),
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (author_id) REFERENCES authors(id)
);

INSERT INTO book_authors (book_id, author_id)
VALUES (
    (SELECT id FROM books WHERE title = 'Jurassic Park'),
    (SELECT id FROM authors WHERE name = 'Michael Crichton')
);
INSERT INTO book_authors (book_id, author_id)
VALUES (
    (SELECT id FROM books WHERE title = 'Station Eleven'),
    (SELECT id FROM authors WHERE name = 'Emily St. John Mandel')
);
INSERT INTO book_authors (book_id, author_id)
VALUES (
    (SELECT id FROM books WHERE title = 'Less'),
    (SELECT id FROM authors WHERE name = 'Andrew Sean Greer')
);