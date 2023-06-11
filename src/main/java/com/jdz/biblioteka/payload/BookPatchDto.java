package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookPatchDto {
    private String name;
    private String lastName;
    private String category;
    private String publishingHouse;
}
