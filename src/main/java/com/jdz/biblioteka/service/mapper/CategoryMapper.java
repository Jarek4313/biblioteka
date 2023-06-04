package com.jdz.biblioteka.service.mapper;

import com.jdz.biblioteka.model.Category;
import com.jdz.biblioteka.payload.CategoryDto;

import java.util.Objects;

public class CategoryMapper {
    public static Category map(CategoryDto categoryDto) {
        if (Objects.isNull(categoryDto)) {
            return null;
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        return category;
    }

    public static CategoryDto map(Category category) {
        if (Objects.isNull(category)) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
