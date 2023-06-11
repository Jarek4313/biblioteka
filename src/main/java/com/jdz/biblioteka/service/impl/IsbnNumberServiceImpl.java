package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.model.IsbnNumber;
import com.jdz.biblioteka.payload.BookSimpleDto;
import com.jdz.biblioteka.payload.IsbnNumberDto;
import com.jdz.biblioteka.repository.BookRepository;
import com.jdz.biblioteka.repository.IsbnNumberRepository;
import com.jdz.biblioteka.service.IsbnNumberService;
import com.jdz.biblioteka.service.mapper.IsbnNumberMapper;
import com.jdz.biblioteka.service.util.IsbnNumberUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class IsbnNumberServiceImpl implements IsbnNumberService {
    private final IsbnNumberRepository isbnNumberRepository;
    private final BookRepository bookRepository;

    private final IsbnNumberMapper isbnNumberMapper;

    @Override
    public List<IsbnNumberDto> createIsbnNumber(Book book) {
        return commonGenerateIsbnNumber(book);
    }
    @Override
    public List<IsbnNumberDto> createIsbnNumber(BookSimpleDto bookSimpleDto) {
        Book book = bookRepository.findBookByTitle(bookSimpleDto.getTitle());

        return commonGenerateIsbnNumber(book);
    }

    private List<IsbnNumberDto> commonGenerateIsbnNumber(Book book) {
        if (Objects.isNull(book)) {
            return null;
        }

        int isbnNumberNeedCount = IsbnNumberUtil.getIsbnNumberNeedCount(
                book.getQuantity(),
                isbnNumberRepository.findAllIsbnNumberByBook(book).size()
        );

        List<IsbnNumberDto> isbnNumberDtoList = new ArrayList<>();

        if (isbnNumberNeedCount == 0) {
            return isbnNumberDtoList;
        }

        for (int i=0; i<isbnNumberNeedCount; i++) {
            IsbnNumber isbnNumber = isbnNumberMapper.map(book);
            isbnNumber.setIsbn(IsbnNumberUtil.generateIsbnNumber());
            IsbnNumber newIsbnNumber = isbnNumberRepository.save(isbnNumber);
            isbnNumberDtoList.add(isbnNumberMapper.map(newIsbnNumber));
        }

        return isbnNumberDtoList;
    }
}
