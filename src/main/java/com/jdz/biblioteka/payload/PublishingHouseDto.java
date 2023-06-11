package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PublishingHouseDto {
    private String name;
    private int booksCount;
    private List<BookSimpleDto> listOfBooks;
}
