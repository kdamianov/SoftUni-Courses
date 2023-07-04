package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksWithAgeRestrictionMatching(String input) {
        return bookRepository.findAllByAgeRestriction(AgeRestriction.valueOf(input.toUpperCase()))
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .toList();
    }

    @Override
    public List<String> findAllBooksByEditionTypeWithCopiesLessThan(String editionType, int copies) {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(EditionType.valueOf(editionType.toUpperCase()), copies)
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .toList();
    }

    @Override
    public List<String> findAllBooksNotBetween(BigDecimal lowerPrice, BigDecimal upperPrice) {
        List<String> list = bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lowerPrice, upperPrice)
                .stream()
                .map(book -> String.format("%s - $%.2f", book.getTitle(), book.getPrice()))
                .toList();
        return list;

    }

    @Override
    public List<String> findAllBooksNotReleasedInYear(int releaseYear) {
        LocalDate lowerYear = LocalDate.of(releaseYear, 1, 1);
        LocalDate upperYear = LocalDate.of(releaseYear, 12, 31);
        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(lowerYear, upperYear)
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .toList();
    }

    @Override
    public List<String> findAllBooksReleasedBefore(LocalDate date) {
        return bookRepository.findBooksByReleaseDateBefore(date)
                .stream()
                .map(book -> String.format("%s %s %.2f", book.getTitle(), book.getEditionType(), book.getPrice()))
                .toList();
    }

    @Override
    public List<String> findAllBooksContaining(String containedString) {
        return bookRepository.findAllByTitleContaining(containedString)
                .stream()
                .map(book -> String.format("%s", book.getTitle()))
                .toList();
    }

    @Override
    public List<String> findAllBooksWithAuthorsLastNameStartingWith(String startingLetters) {
        return bookRepository.findAllByAuthor_LastNameStartsWith(startingLetters)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .toList();
    }

    @Override
    public int findBooksCountWithTitleSizeLongerThan(int number) {
        return bookRepository.countAllByTitleSizeGreaterThan(number);
    }

    @Override
    public List<String> findInformationOnBookTitle(String title) {

        return bookRepository.findAllByTitleEquals(title)
                .stream()
                .map(book -> String.format("%s %s %s %.2f",
                        book.getTitle(),
                        book.getEditionType(),
                        book.getAgeRestriction(),
                        book.getPrice()))
                .toList();
    }

    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
