package com.jdz.biblioteka.controller;

import com.jdz.biblioteka.model.IsbnNumber;
import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.payload.IsbnNumberDto;
import com.jdz.biblioteka.service.IsbnNumberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/isbn-number")
public class IsbnNumberController {

    private IsbnNumberService isbnNumberService;

    @PostMapping
    public ResponseEntity<List<IsbnNumberDto>> createIsbnNumber(@RequestBody BookSimpleDto bookSimpleDto) {
        return new ResponseEntity<List<IsbnNumberDto>>(isbnNumberService.createIsbnNumber(bookSimpleDto), HttpStatus.CREATED);
    }
}
