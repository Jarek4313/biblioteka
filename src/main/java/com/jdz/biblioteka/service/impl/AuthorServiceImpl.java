package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.exception.ResourceNotFoundException;
import com.jdz.biblioteka.model.Author;
import com.jdz.biblioteka.payload.AuthorDto;
import com.jdz.biblioteka.repository.AuthorRepository;
import com.jdz.biblioteka.service.AuthorService;
import com.jdz.biblioteka.service.mapper.AuthorMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author author = authorMapper.map(authorDto);

        Author newAuthor = authorRepository.save(author);
        return authorMapper.map(newAuthor);
    }

    @Override
    public AuthorDto getAuthorById(int id) {
        Author author = authorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author", "id", id));

        return authorMapper.map(author);
    }
}
