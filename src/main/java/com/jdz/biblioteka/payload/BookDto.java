package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto {
    private String title;
    private Integer quantity;
}
