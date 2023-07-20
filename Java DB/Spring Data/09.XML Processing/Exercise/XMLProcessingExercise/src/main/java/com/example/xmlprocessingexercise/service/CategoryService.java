package com.example.xmlprocessingexercise.service;

import com.example.xmlprocessingexercise.model.dto.categories.CategorySeedDto;
import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusRootDto;
import com.example.xmlprocessingexercise.model.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    long getCount();

    void seedCategories(List<CategorySeedDto> categories);

    Set<Category> getRandomCategories();

    CategoryStatusRootDto getCategoryStats();
}
