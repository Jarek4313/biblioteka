package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.model.IsbnNumber;
import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.payload.IsbnNumberDto;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class IsbnNumberMapper {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    public IsbnNumber map(IsbnNumberDto isbnNumberDto) {
        if (Objects.isNull(isbnNumberDto)) {
            return null;
        }

        IsbnNumber isbnNumber = new IsbnNumber();

        isbnNumber.setBook(bookRepository.findBookByTitle(isbnNumberDto.getBookSimpleDto().getTitle()));

        return isbnNumber;
    }

    public IsbnNumberDto map(IsbnNumber isbnNumber) {
        if (Objects.isNull(isbnNumber)) {
            return null;
        }

        IsbnNumberDto isbnNumberDto = new IsbnNumberDto();

        isbnNumberDto.setIsbn(isbnNumber.getIsbn());
        isbnNumberDto.setBookSimpleDto(bookMapper.mapSimple(isbnNumber.getBook()));

        return isbnNumberDto;
    }

    public IsbnNumber map(BookSimpleDto bookSimpleDto) {
        if (Objects.isNull(bookSimpleDto)) {
            return null;
        }

        IsbnNumber isbnNumber = new IsbnNumber();

        isbnNumber.setBook(bookRepository.findBookByTitle(bookSimpleDto.getTitle()));

        return isbnNumber;
    }

    public IsbnNumber map(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }

        IsbnNumber isbnNumber = new IsbnNumber();

        isbnNumber.setBook(bookRepository.findBookByTitle(book.getTitle()));

        return isbnNumber;
    }
}
