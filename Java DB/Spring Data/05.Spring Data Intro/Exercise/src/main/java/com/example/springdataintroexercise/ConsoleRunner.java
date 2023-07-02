package com.example.springdataintroexercise;

import com.example.springdataintroexercise.models.Book;
import com.example.springdataintroexercise.services.AuthorService;
import com.example.springdataintroexercise.services.BookService;
import com.example.springdataintroexercise.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final CategoryService categoryService; //Must be injected into this class via Ctor
    private final AuthorService authorService; //Must be injected into this class via Ctor
    private final BookService bookService; //Must be injected into this class via Ctor

    public ConsoleRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();


        // printAllBooksAfterYear(2000);
        // printAllAuthorsWithBooksReleasedBeforeYear(1990);
        // printAllAuthorsByBooksCountDesc();
        // printAllBooksByAuthorNameByReleaseDateAndTitle("George", "Powell");

    }

    private void printAllBooksByAuthorNameByReleaseDateAndTitle(String firstName, String lastName) {
        bookService.findAllBooksByAuthorsFirstAndLastNameByReleaseDateAndTitle(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsByBooksCountDesc() {
        authorService.getAllAuthorsOrderedByBooksCount()
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithBooksReleasedBeforeYear(int year) {
        bookService.findAllAuthorsWithBooksReleasedBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
