package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.BookResponse;
import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.repository.CategoryRepository;
import com.jdz.biblioteka.service.CategoryService;
import com.jdz.biblioteka.service.impl.CategoryServiceImpl;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
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
        bookDto.setCategory(Objects.nonNull(book.getCategory()) ?
                categoryRepository.getReferenceById(book.getCategory().getId()).getName() : "");
        bookDto.setPageNumber(ObjectUtils.defaultIfNull(book.getPageNumber(), 0));
        bookDto.setPublicationYear(ObjectUtils.defaultIfNull(book.getPublicationYear(), 0));

        if (!Objects.isNull(book.getAuthor())) {
            bookDto.setAuthor("%s %s".formatted(book.getAuthor().getName(), book.getAuthor().getLastName()));
        }
        if (!Objects.isNull(book.getPublishingHouse())) {
            bookDto.setPublishingHouse("%s".formatted(book.getPublishingHouse().getName()));
        }

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
        book.setPageNumber(ObjectUtils.defaultIfNull(bookDto.getPageNumber(), 0));
        book.setPublicationYear(ObjectUtils.defaultIfNull(bookDto.getPublicationYear(), 0));

        return book;
    }

    public BookResponse getResponse(List<BookDto> content, Page<Book> books) {
        if (CollectionUtils.isEmpty(content) && Objects.isNull(books)) {
            return null;
        }

        BookResponse bookResponse = new BookResponse();

        bookResponse.setContent(content);
        bookResponse.setPageNumber(books.getNumber());
        bookResponse.setPageSize(books.getSize());
        bookResponse.setTotalElement(books.getTotalElements());
        bookResponse.setTotalPages(books.getTotalPages());
        bookResponse.setLast(books.isLast());
        return bookResponse;
    }

    public BookSimpleDto mapSimple(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }

        BookSimpleDto bookSimpleDto = new BookSimpleDto();

        bookSimpleDto.setTitle(book.getTitle());
        bookSimpleDto.setCategory(book.getCategory().getName());

        return bookSimpleDto;
    }
}
