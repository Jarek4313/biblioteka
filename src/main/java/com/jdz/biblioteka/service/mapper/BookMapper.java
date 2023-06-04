package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.repository.CategoryRepository;
import com.jdz.biblioteka.service.CategoryService;
import com.jdz.biblioteka.service.impl.CategoryServiceImpl;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;


@Component
@RequiredArgsConstructor
public class BookMapper {
    private final CategoryRepository categoryRepository;

    public BookDto map(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }
        BookDto bookDto = new BookDto();
        bookDto.setTitle(Objects.nonNull(book.getTitle()) ? book.getTitle() : "no title");
        bookDto.setQuantity(book.getQuantity());
        bookDto.setCategory(book.getCategory().getName());
        return bookDto;
    }

    public Book map(BookDto bookDto) {
        if (Objects.isNull(bookDto)) {
            return null;
        }
        Book book = new Book();

        book.setTitle(Objects.nonNull(bookDto.getTitle()) ? bookDto.getTitle() : "no title");
        book.setQuantity(bookDto.getQuantity());
        book.setCategory(categoryRepository.findCategoryByName(bookDto.getCategory()));

        return book;
    }
}
