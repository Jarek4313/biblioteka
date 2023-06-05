package com.jdz.biblioteka.repository;

import com.jdz.biblioteka.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Author findAuthorByNameAndLastName(String name, String lastName);
}
