package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Author;
import com.jdz.biblioteka.payload.AuthorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthorMapper {

    private final BookMapper bookMapper;

    public AuthorDto map(Author author) {
        if (Objects.isNull(author)) {
            return null;
        }
        AuthorDto authorDto = new AuthorDto();

        authorDto.setName(author.getName());
        authorDto.setLastName(author.getLastName());
        authorDto.setNumberOfBooks(author.getBooks().size());
        authorDto.setListOfBooks(author.getBooks()
                .stream()
                .map(bookMapper::mapSimple)
                .collect(Collectors.toList()));

        return authorDto;
    }

    public Author map(AuthorDto authorDto) {
        if (Objects.isNull(authorDto)) {
            return null;
        }
        Author author = new Author();
        author.setName(authorDto.getName());
        author.setLastName(authorDto.getLastName());

        return author;
    }
}
