package com.jdz.biblioteka.controller;

import com.jdz.biblioteka.payload.AuthorDto;
import com.jdz.biblioteka.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDto> createBook(@RequestBody AuthorDto authorDto) {
        return new ResponseEntity<>(authorService.createAuthor(authorDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthor(@PathVariable int id) {
        return new ResponseEntity<>(authorService.getAuthorById(id), HttpStatus.OK);
    }
}
