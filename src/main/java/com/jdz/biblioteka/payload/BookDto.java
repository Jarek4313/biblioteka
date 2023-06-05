package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private int quantity;
    private String category;
    private int pageNumber;
    private int publicationYear;
    private String author;
    private String publishingHouse;
}
