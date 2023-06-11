package com.jdz.biblioteka.service;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.payload.IsbnNumberDto;

import java.util.List;

public interface IsbnNumberService {
    List<IsbnNumberDto> createIsbnNumber(Book book);

    List<IsbnNumberDto> createIsbnNumber(BookSimpleDto bookSimpleDto);
}
