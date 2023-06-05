package com.jdz.biblioteka.service;

import com.jdz.biblioteka.model.Author;
import com.jdz.biblioteka.payload.AuthorDto;

public interface AuthorService {
    AuthorDto createAuthor(AuthorDto authorDto);

    AuthorDto getAuthorById(int id);
}
