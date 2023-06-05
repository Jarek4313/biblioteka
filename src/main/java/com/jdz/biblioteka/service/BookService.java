package com.jdz.biblioteka.service;

import com.jdz.biblioteka.payload.AuthorDto;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.BookPatchDto;
import com.jdz.biblioteka.payload.BookResponse;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(int id);

    BookResponse getAllBooks(int pageNo, int pageSize, String sortBy, String sortDir);

    BookDto patchBook(int id, BookPatchDto authorDto);
}
