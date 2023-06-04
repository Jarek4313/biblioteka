package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.repository.CategoryRepository;
import com.jdz.biblioteka.service.BookService;
import com.jdz.biblioteka.service.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.map(bookDto);
        book.setCategory(categoryRepository.findCategoryByName(bookDto.getCategory()));

        Book newBook = bookRepository.save(book);
        return bookMapper.map(newBook);
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        return bookMapper.map(book);
    }


}
