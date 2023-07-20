package com.example.xmlprocessingexercise;

import com.example.xmlprocessingexercise.model.dto.categories.CategorySeedRootDto;
import com.example.xmlprocessingexercise.model.dto.categories.CategoryStatusRootDto;
import com.example.xmlprocessingexercise.model.dto.products.ProductSeedRootDto;
import com.example.xmlprocessingexercise.model.dto.products.ProductViewRootDto;
import com.example.xmlprocessingexercise.model.dto.users.UserSeedRootDto;
import com.example.xmlprocessingexercise.model.dto.users.UserViewRootDto;
import com.example.xmlprocessingexercise.model.dto.users.UserWrapperDto;
import com.example.xmlprocessingexercise.service.CategoryService;
import com.example.xmlprocessingexercise.service.ProductService;
import com.example.xmlprocessingexercise.service.UserService;
import com.example.xmlprocessingexercise.util.XMLParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.Scanner;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    //константите ще се ползват само тук!
    private static final String RESOURCES_FILES_PATH = "src/main/resources/files/";
    private static final String OUTPUT_FILES_PATH = "src/main/resources/files/output/";
    private static final String CATEGORIES_FILE_NAME = "categories.xml";
    private static final String USERS_FILE_NAME = "users.xml";
    private static final String PRODUCTS_FILE_NAME = "products.xml";
    private static final String PRODUCTS_IN_RANGE_FILE = "products-in-range.xml";
    private static final String USERS_SOLD_PRODUCTS_FILE = "users-sold-products.xml";
    private static final String CATEGORIES_BY_PRODUCTS_FILE = "categories-by-products.xml";
    private static final String USERS_AND_PRODUCTS = "users-and-products.xml";
    private final XMLParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    private final Scanner scanner;

    public CommandLineRunner(XMLParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService, Scanner scanner) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.scanner = scanner;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Please, select query No (1-4)");
        int queryNum = Integer.parseInt(scanner.nextLine());
        switch (queryNum){
            case 1 -> {
                productsInRange();
                System.out.printf("The result war written in file %s.%n", PRODUCTS_IN_RANGE_FILE);
            }
            case 2 -> {
                successfullySoldProducts();
                System.out.printf("The result war written in file %s.%n", USERS_SOLD_PRODUCTS_FILE);
            }
            case 3 -> {
                categoriesByProductsCount();
                System.out.printf("The result war written in file %s.%n", CATEGORIES_BY_PRODUCTS_FILE);
            }
            case 4 -> {
                usersAndProducts();
                System.out.printf("The result war written in file %s.%n", USERS_AND_PRODUCTS);
            }
        }

        System.out.println("Thank you!");
    }

    private void usersAndProducts() throws JAXBException {
        UserWrapperDto usersOverall = userService.getUsersWithSoldProductsWrapper();
        xmlParser.toFile(OUTPUT_FILES_PATH+USERS_AND_PRODUCTS, usersOverall);
    }

    private void categoriesByProductsCount() throws JAXBException {
        CategoryStatusRootDto categoryStats = categoryService.getCategoryStats();
        xmlParser.toFile(OUTPUT_FILES_PATH + CATEGORIES_BY_PRODUCTS_FILE, categoryStats);
    }

    private void successfullySoldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto = userService.findAllUsersWithMoreThanOneSoldProducts();

        xmlParser.toFile(OUTPUT_FILES_PATH + USERS_SOLD_PRODUCTS_FILE, userViewRootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto productViewRootDto = productService.findProductsInRangeWithNoBuyer();

        xmlParser.toFile(OUTPUT_FILES_PATH + PRODUCTS_IN_RANGE_FILE, productViewRootDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (categoryService.getCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = xmlParser.fromFile(RESOURCES_FILES_PATH + CATEGORIES_FILE_NAME,
                    CategorySeedRootDto.class);

            categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (userService.getCount() == 0) {
            UserSeedRootDto userSeedRootDto = xmlParser.fromFile(RESOURCES_FILES_PATH + USERS_FILE_NAME,
                    UserSeedRootDto.class);

            userService.seedUsers(userSeedRootDto.getUsers());
        }

        if (productService.getCount() == 0) {
            ProductSeedRootDto productSeedRootDto = xmlParser.fromFile(RESOURCES_FILES_PATH + PRODUCTS_FILE_NAME,
                    ProductSeedRootDto.class);

            productService.seedProducts(productSeedRootDto.getProducts());
        }
    }
}
