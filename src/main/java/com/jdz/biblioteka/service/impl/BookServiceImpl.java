package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.service.BookService;
import com.jdz.biblioteka.service.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = BookMapper.map(bookDto);

        Book newBook = bookRepository.save(book);
        return BookMapper.map(newBook);
    }
}
