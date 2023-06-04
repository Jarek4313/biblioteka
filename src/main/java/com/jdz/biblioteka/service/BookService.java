package com.jdz.biblioteka.service;

import com.jdz.biblioteka.payload.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);

    BookDto getBookById(int id);
}
