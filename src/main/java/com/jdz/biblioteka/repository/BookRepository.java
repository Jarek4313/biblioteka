package com.jdz.biblioteka.repository;

import com.jdz.biblioteka.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select book from Book book"
            + " left join fetch book.category")
    Page<Book> findAllBooks(Pageable page);
}
