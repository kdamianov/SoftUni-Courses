package bg.softuni.battleships.init;

import bg.softuni.battleships.models.entity.Category;
import bg.softuni.battleships.models.enums.CategoryNameEnum;
import bg.softuni.battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryInit implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            List<Category> categories = Arrays.stream(CategoryNameEnum.values())
                    .map(Category::new)
                    .toList();
            this.categoryRepository.saveAll(categories); //avoiding N+1 problem!
        }
    }
}
