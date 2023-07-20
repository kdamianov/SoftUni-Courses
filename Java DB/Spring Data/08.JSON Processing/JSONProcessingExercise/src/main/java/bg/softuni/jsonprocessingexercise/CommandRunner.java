package bg.softuni.jsonprocessingexercise;

import bg.softuni.jsonprocessingexercise.domain.dto.categories.CategoryStatsDto;
import bg.softuni.jsonprocessingexercise.domain.dto.products.ProductNameAndPriceDto;
import bg.softuni.jsonprocessingexercise.domain.dto.users.UserSoldDto;
import bg.softuni.jsonprocessingexercise.domain.dto.users.UsersWithProductsWrapperDto;
import bg.softuni.jsonprocessingexercise.service.CategoryService;
import bg.softuni.jsonprocessingexercise.service.ProductService;
import bg.softuni.jsonprocessingexercise.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandRunner implements CommandLineRunner {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products_in_range.json";
    private static final String USERS_AND_SOLD_PRODUCTS = "users_and_sold_products.json";
    private static final String CATEGORY_STATISTICS = "categories-by-products.json";
    private static final String USERS_PRODUCTS = "users-and-products.json";
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandRunner(CategoryService categoryService, UserService userService, ProductService productServiceService, BufferedReader bufferedReader, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productServiceService;
        this.bufferedReader = bufferedReader;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Enter task number (1 - 4): ");
        int exerciseNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exerciseNumber) {
            case 1 -> {
                productsInRange();
                System.out.printf("The result is written in file: %s.%n",PRODUCTS_IN_RANGE_FILE_NAME);
            }
            case 2 -> {
                successfullySoldProducts();
                System.out.printf("The result is written in file: %s.%n",USERS_AND_SOLD_PRODUCTS);
            }
            case 3 -> {
                categoriesStats();
                System.out.printf("The result is written in file: %s.%n",CATEGORY_STATISTICS);
            }
            case 4 -> {
                usersAndProducts();
                System.out.printf("The result is written in file: %s.%n",USERS_PRODUCTS);
            }
        }
        System.out.println("Thank you!");
    }

    private void usersAndProducts() throws IOException {
        UsersWithProductsWrapperDto usersWithSoldProductsWrapper = userService.getUsersWithSoldProductsWrapper();

        String content = gson.toJson(usersWithSoldProductsWrapper);

        writeToFile(OUTPUT_FILE_PATH + USERS_PRODUCTS, content);
    }


    private void categoriesStats() throws IOException {
        List<CategoryStatsDto> categoryStatsDtos = categoryService.getAllCategoriesByProductsCount();

        String content = gson.toJson(categoryStatsDtos);

        writeToFile(OUTPUT_FILE_PATH + CATEGORY_STATISTICS, content);
    }

    private void successfullySoldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService
                .findAllUsersWithMoreThanOneSoldProduct();

        String content = gson.toJson(userSoldDtos);


        writeToFile(OUTPUT_FILE_PATH + USERS_AND_SOLD_PRODUCTS, content);

    }

    private void productsInRange() throws IOException {
        List<ProductNameAndPriceDto> productNameAndPriceDtos =
                productService.findAllProductsInRangeOrderByPrice(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(productNameAndPriceDtos);
        writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME, content);
    }

    private void writeToFile(String path, String content) throws IOException {
        Files.write(Path.of(path), Collections.singleton(content));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}
