package bg.softuni.jsonprocessingexercise.service;

import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryStatsDto;
import bg.softuni.jsonprocessingexercise.domain.entities.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> findRandomCategories();

    List<CategoryStatsDto> getAllCategoriesByProductsCount();
}
