-- V7__create_series_table.sql

CREATE TABLE series (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255)
);

ALTER TABLE books
ADD COLUMN series_id BIGINT,
ADD COLUMN series_order INT,
ADD FOREIGN KEY (series_id) REFERENCES series(id);
