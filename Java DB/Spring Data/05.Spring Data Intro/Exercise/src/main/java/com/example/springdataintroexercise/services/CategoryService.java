package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
