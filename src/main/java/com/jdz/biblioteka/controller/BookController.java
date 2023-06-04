package com.jdz.biblioteka.controller;

import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.createBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> readBook(@PathVariable int id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }
}
