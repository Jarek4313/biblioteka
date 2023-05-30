package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookDto;

import java.util.Objects;

public class BookMapper {
    public static BookDto map(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }
        BookDto bookDto = new BookDto();
        bookDto.setTitle(Objects.nonNull(book.getTitle()) ? book.getTitle() : "no title");
        bookDto.setQuantity(book.getQuantity());

        return bookDto;
    }

    public static Book map(BookDto bookDto) {
        if (Objects.isNull(bookDto)) {
            return null;
        }
        Book book = new Book();
        book.setTitle(Objects.nonNull(bookDto.getTitle()) ? bookDto.getTitle() : "no title");
        book.setQuantity(bookDto.getQuantity());

        return book;
    }
}
