package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.exception.ResourceNotFoundException;
import com.jdz.biblioteka.model.Author;
import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.model.Category;
import com.jdz.biblioteka.payload.AuthorDto;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.BookPatchDto;
import com.jdz.biblioteka.payload.BookResponse;
import com.jdz.biblioteka.repository.AuthorRepository;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.repository.CategoryRepository;
import com.jdz.biblioteka.service.BookService;
import com.jdz.biblioteka.service.mapper.BookMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;

    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookMapper.map(bookDto);
        book.setCategory(categoryRepository
                .findCategoryByName(bookDto.getCategory()));

        Book newBook = bookRepository.save(book);
        return bookMapper.map(newBook);
    }

    @Override
    public BookDto getBookById(int id) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
        return bookMapper.map(book);
    }

    @Override
    public BookResponse getAllBooks(int pageNumber, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Book> books = bookRepository.findAllBooks(pageable);

        List<Book> listOfBooks = books.getContent();
        List<BookDto> content = listOfBooks.stream()
                .map(bookMapper::map)
                .toList(); //.collect(Collectors.toList());

        return bookMapper.getResponse(content, books);
    }

    @Override
    public BookDto patchBook(int id, BookPatchDto bookPatchDto) {
        Book book = bookRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));

        Author author = authorRepository.findAuthorByNameAndLastName(bookPatchDto.getName(), bookPatchDto.getLastName());
        Category category = categoryRepository.findCategoryByName(bookPatchDto.getCategory());

        if (!Objects.isNull(author)) {
            book.setAuthor(author);
        }
        if (!Objects.isNull(category)) {
            book.setCategory(category);
        }

        bookRepository.save(book);

        return bookMapper.map(book);
    }


}
