package com.jdz.biblioteka.service;

import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.payload.IsbnNumberDto;

import java.util.List;

public interface IsbnNumberService {
    List<IsbnNumberDto> createIsbnNumber(BookSimpleDto bookSimpleDto);
}
