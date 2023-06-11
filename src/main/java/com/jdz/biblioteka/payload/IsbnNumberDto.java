package com.jdz.biblioteka.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IsbnNumberDto {
    private String isbn;
    private BookSimpleDto bookSimpleDto;
}
