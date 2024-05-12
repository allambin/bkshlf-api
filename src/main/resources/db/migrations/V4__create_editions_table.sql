-- V5__create_user_books_table.sql

CREATE TABLE editions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    isbn10 VARCHAR(10) UNIQUE,
    isbn13 VARCHAR(13) UNIQUE,
    book_id VARCHAR(36),
    FOREIGN KEY (book_id) REFERENCES books(id)
);

INSERT INTO editions (isbn10, isbn13, book_id)
VALUES (
    '0123456789',
    '9876543210',
    (SELECT id FROM books WHERE title = 'Jurassic Park')
);

INSERT INTO editions (isbn10, isbn13, book_id)
VALUES (
    '2345678901',
    '9789876543210',
    (SELECT id FROM books WHERE title = 'Jurassic Park')
);

INSERT INTO editions (isbn10, isbn13, book_id)
VALUES (
    '2345678911',
    '9782345678901',
    (SELECT id FROM books WHERE title = 'Station Eleven')
);

INSERT INTO editions (isbn10, isbn13, book_id)
VALUES (
    '8765432109',
    '9788765432109',
    (SELECT id FROM books WHERE title = 'Station Eleven')
);

INSERT INTO editions (isbn10, isbn13, book_id)
VALUES (
    '5432109876',
    '9785432109876',
    (SELECT id FROM books WHERE title = 'Less')
);