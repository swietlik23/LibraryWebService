package com.swietlicki.library.repository;

import com.swietlicki.library.model.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b LEFT JOIN FETCH b.borrowing ORDER BY b.id")
    List<Book> findAllBooks(Pageable page);

    @Query("SELECT b FROM Book b WHERE LOWER(title) LIKE %:title% ")
    List<Book> findAllByTitle(@Param("title") String title, Pageable page);
    
}
