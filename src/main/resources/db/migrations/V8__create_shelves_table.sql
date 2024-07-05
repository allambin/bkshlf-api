-- V8__create_shelves_table.sql

CREATE TABLE shelves (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    shortname VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    is_default BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE (user_id, shortname)
);

CREATE TABLE book_shelves (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    shelf_id BIGINT NOT NULL,
    book_id VARCHAR(36) NOT NULL,
    added_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (shelf_id) REFERENCES shelves(id),
    FOREIGN KEY (book_id) REFERENCES books(id)
);
