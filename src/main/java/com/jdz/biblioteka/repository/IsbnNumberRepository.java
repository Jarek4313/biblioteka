package com.jdz.biblioteka.repository;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.model.IsbnNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IsbnNumberRepository extends JpaRepository<IsbnNumber, Integer> {

    List<IsbnNumber> findAllIsbnNumberByBook(Book book);

}
