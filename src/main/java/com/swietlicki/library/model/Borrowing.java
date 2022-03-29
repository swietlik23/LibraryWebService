package com.swietlicki.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Borrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    private long readerId;

//    --    borrow_date timestamp,
//--    return_date timestamp,
//--    book_id BIGINT NOT NULL,
//--    reader_id BIGINT NOT NULL

}
