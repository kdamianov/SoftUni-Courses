package com.example.xmlprocessingexercise.service.impl;

import com.example.xmlprocessingexercise.model.dto.categories.CategorySeedDto;
import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusDto;
import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusRootDto;
import com.example.xmlprocessingexercise.model.entities.Category;
import com.example.xmlprocessingexercise.repositories.CategoryRepository;
import com.example.xmlprocessingexercise.service.CategoryService;
import com.example.xmlprocessingexercise.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public long getCount() {
        return categoryRepository.count();
    }

    @Override
    public void seedCategories(List<CategorySeedDto> categories) {
        if (categoryRepository.count() == 0) {
            categories
                    .stream()
                    .filter(validationUtil::isValid)
                    .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                    .forEach(categoryRepository::save);
        }
    }

    @Override
    public Set<Category> getRandomCategories() {
        Set<Category> randomCategories = new HashSet<>();
        long categoryCount = categoryRepository.count();

        for (int i = 0; i < 2; i++) {
            long randomId = ThreadLocalRandom.current()
                    .nextLong(1, categoryCount);

            randomCategories.add(categoryRepository
                    .findById(randomId).orElse(null));
        }

        return randomCategories;
    }

    @Override
    public CategoryStatusRootDto getCategoryStats() {
        CategoryStatusRootDto categoryStatsRootDto = new CategoryStatusRootDto();
        categoryStatsRootDto.setCategories(categoryRepository
                .getProductStats()
                .stream()
                .map(category -> modelMapper.map(category, CategoryStatusDto.class))
                .toList());
        return categoryStatsRootDto;
    }
}
