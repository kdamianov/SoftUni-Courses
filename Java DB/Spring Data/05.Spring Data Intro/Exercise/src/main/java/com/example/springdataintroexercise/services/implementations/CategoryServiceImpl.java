package com.example.springdataintroexercise.services.implementations;

import com.example.springdataintroexercise.models.Category;
import com.example.springdataintroexercise.repositories.CategoryRepository;
import com.example.springdataintroexercise.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_PATH = "src/main/resources/files/categories.txt";
    private final CategoryRepository categoryRepository; //must be injected via Ctor

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(CATEGORIES_PATH)) //read the information from resource file
                .stream()
                .filter(r -> !r.isEmpty())
                .forEach(categoryName -> {
                    Category category = new Category(categoryName); //create category

                    categoryRepository.save(category); //save the current Object
                });

    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> categories = new HashSet<>();
        int randomInt = ThreadLocalRandom.current().nextInt(1, 3);
        long catRepoCount = categoryRepository.count();

        for (int i = 0; i < randomInt; i++) {
            long randomId = ThreadLocalRandom.current()
                    .nextLong(1, catRepoCount + 1);

            Category category = categoryRepository
                    .findById(randomId)
                    .orElse(null);

            categories.add(category);
        }
        return categories;
    }
}

