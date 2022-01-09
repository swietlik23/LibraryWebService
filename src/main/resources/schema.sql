CREATE TABLE BOOK (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    title VARCHAR(1000) NOT NULL,
    authors VARCHAR(1000) NOT NULL,
    language_code VARCHAR(20) NOT NULL,
    num_pages VARCHAR(15000) NOT NULL,
    publication_date VARCHAR(400) NOT NULL,
    publisher VARCHAR(400) NOT NULL
);

CREATE TABLE READER (
    id BIGINT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(400) NOT NULL,
    last_name VARCHAR(400) NOT NULL,
    email VARCHAR(400) NOT NULL
);

CREATE TABLE BORROWING (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    borrow_date timestamp,
    return_date timestamp,
    book_id BIGINT,
    reader_id BIGINT
);

ALTER TABLE BORROWING ADD CONSTRAINT borrowing_book_id FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE BORROWING ADD CONSTRAINT borrowing_reader_id FOREIGN KEY (reader_id) REFERENCES reader(id)