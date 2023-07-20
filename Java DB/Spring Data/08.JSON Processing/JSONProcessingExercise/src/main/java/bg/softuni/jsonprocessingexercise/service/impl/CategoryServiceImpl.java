package bg.softuni.jsonprocessingexercise.service.impl;

import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategorySeedDto;
import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryStatsDto;
import bg.softuni.jsonprocessingexercise.domain.entities.Category;
import bg.softuni.jsonprocessingexercise.repositories.CategoryRepository;
import bg.softuni.jsonprocessingexercise.service.CategoryService;
import bg.softuni.jsonprocessingexercise.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import static bg.softuni.jsonprocessingexercise.constants.GlobalConstants.RESOURCES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final String CATEGORIES_FILE_NAME = "categories.json";
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {
        if (categoryRepository.count() > 0) {
            return;
        }

        String categoriesFileContent = Files
                .readString(Path.of(RESOURCES_FILE_PATH + CATEGORIES_FILE_NAME));


        CategorySeedDto[] categoriesSeedDtos = gson
                .fromJson(categoriesFileContent, CategorySeedDto[].class);

        Arrays.stream(categoriesSeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> findRandomCategories() {
        Set<Category> randomCategoriesSet = new HashSet<>();
        int categoriesCount = ThreadLocalRandom
                .current().nextInt(1, 3);

        long totalCategoriesCount = categoryRepository.count();

        for (int i = 0; i < categoriesCount; i++) {
            long randomCategoryId = ThreadLocalRandom
                    .current().nextLong(1, totalCategoriesCount + 1);

            randomCategoriesSet.add(categoryRepository.findById(randomCategoryId).orElse(null));
            //добавяме random Категория по radnom Id
        }

        return randomCategoriesSet;
    }

    @Override
    public List<CategoryStatsDto> getAllCategoriesByProductsCount() {
        List<CategoryStatsDto> productStats = categoryRepository.getProductStats();
        return productStats;
    }


}
