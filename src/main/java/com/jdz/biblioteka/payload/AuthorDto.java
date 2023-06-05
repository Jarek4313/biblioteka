package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorDto {
    private String name;
    private String lastName;
    private int numberOfBooks;
    private List<BookSimpleDto> listOfBooks;
}
