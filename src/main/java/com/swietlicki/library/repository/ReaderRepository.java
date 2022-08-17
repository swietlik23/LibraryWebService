package com.swietlicki.library.repository;

import com.swietlicki.library.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader findByEmail(String email);
}
