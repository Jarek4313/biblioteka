package com.jdz.biblioteka.service.impl;

import com.jdz.biblioteka.model.Book;
import com.jdz.biblioteka.model.Category;
import com.jdz.biblioteka.payload.BookDto;
import com.jdz.biblioteka.payload.CategoryDto;
import com.jdz.biblioteka.repository.CategoryRepository;
import com.jdz.biblioteka.service.CategoryService;
import com.jdz.biblioteka.service.mapper.CategoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.map(categoryDto);

        Category newCategory = categoryRepository.save(category);
        return CategoryMapper.map(newCategory);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.getReferenceById(id);
    }


}
