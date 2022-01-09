package com.swietlicki.library.repository;

import com.swietlicki.library.model.Borrowing;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepisitory extends JpaRepository<Borrowing, Long> {

    @Query("SELECT b FROM Borrowing b")
    List<Borrowing> findAllBorrowings(Pageable page);

}
