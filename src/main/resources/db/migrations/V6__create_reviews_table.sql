-- V6__create_reviews_table.sql

CREATE TABLE reviews (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    book_id VARCHAR(36),
    user_id BIGINT,
    rating INT CHECK (rating >= 1 AND rating <= 5),
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (book_id) REFERENCES books(id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    UNIQUE(book_id, user_id)
);