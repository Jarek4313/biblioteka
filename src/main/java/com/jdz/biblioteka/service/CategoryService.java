package com.jdz.biblioteka.service;

import com.jdz.biblioteka.model.Category;
import com.jdz.biblioteka.payload.CategoryDto;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    Category findById(int id);
}
