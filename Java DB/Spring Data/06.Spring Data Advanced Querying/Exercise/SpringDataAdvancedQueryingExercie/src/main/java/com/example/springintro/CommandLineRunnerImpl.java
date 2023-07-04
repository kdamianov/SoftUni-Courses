package com.example.springintro;

import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
//        printAllBooksWithAgeRestriction("miNor");
//        printAllBooksByEditionTypeWithLessCopiesThan("gold", 5000);
//        printAllBooksWithPriceNotBetween(BigDecimal.valueOf(5), BigDecimal.valueOf(40));
//        printAllBooksNotReleasedInYear(2000);
//        printAllBooksReleasedBefore(LocalDate.parse("12-04-1992", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
//        printAllAuthorsWithFirstNameEndingIn("e");
//        printAllBookTitlesContaining("WOR");
//        printAllBooksWithAuthorsLastNameStartingWith("Ric");
//        printBooksCountWithTitleSizeLongerThan(12);
//        printTotalBookCopiesByAuthor();
//        printBookInformation("Things Fall Apart");



    }

    private void printBookInformation(String title) {
        bookService.findInformationOnBookTitle(title)
                .forEach(System.out::println);
    }

    private void printTotalBookCopiesByAuthor() {
        authorService.findAllBookCopiesByAuthor()
                .forEach(System.out::println);
    }


    private void printBooksCountWithTitleSizeLongerThan(int number) {
        int count = bookService.findBooksCountWithTitleSizeLongerThan(number);
        System.out.printf("There are %d books with longer titles than %d symbols.%n", count, number);
//        System.out.println(bookService.findBooksCountWithTitleSizeLongerThan(number));
    }

    private void printAllBooksWithAuthorsLastNameStartingWith(String startingLetters) {
        bookService.findAllBooksWithAuthorsLastNameStartingWith(startingLetters)
                .forEach(System.out::println);
    }

    private void printAllBookTitlesContaining(String containedString) {
        bookService.findAllBooksContaining(containedString)
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithFirstNameEndingIn(String endLetter) {
        authorService.findAllAuthorsWithFirstNameEndingIn(endLetter)
                .forEach(System.out::println);
    }

    private void printAllBooksReleasedBefore(LocalDate date) {
        bookService.findAllBooksReleasedBefore(date)
                .forEach(System.out::println);
    }


    private void printAllBooksNotReleasedInYear(int releaseYear) {
        bookService.findAllBooksNotReleasedInYear(releaseYear)
                .forEach(System.out::println);
    }

    private void printAllBooksWithPriceNotBetween(BigDecimal lowerPrice, BigDecimal upperPrice) {
        bookService.findAllBooksNotBetween(lowerPrice, upperPrice)
                .forEach(System.out::println);
    }

    private void printAllBooksByEditionTypeWithLessCopiesThan(String editionType, int copies) {
        bookService.findAllBooksByEditionTypeWithCopiesLessThan(editionType, copies)
                .forEach(System.out::println);
    }


    private void printAllBooksWithAgeRestriction(String input) {
        bookService.findAllBooksWithAgeRestrictionMatching(input)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
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
