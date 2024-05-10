-- V5__create_user_books_table.sql

CREATE TABLE user_books (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id VARCHAR(36),
    user_id BIGINT,
    edition_id BIGINT,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (edition_id) REFERENCES editions(id),
    UNIQUE (book_id, user_id, edition_id)
);