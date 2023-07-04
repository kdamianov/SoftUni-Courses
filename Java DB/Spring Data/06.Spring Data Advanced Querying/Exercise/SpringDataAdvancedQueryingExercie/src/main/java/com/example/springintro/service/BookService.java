package com.example.springintro.service;

import com.example.springintro.model.entity.Book;

import javax.print.DocFlavor;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksWithAgeRestrictionMatching(String input);

    List<String> findAllBooksByEditionTypeWithCopiesLessThan(String editionType, int copies);

    List<String> findAllBooksNotBetween(BigDecimal lowerPrice, BigDecimal upperPrice);

    List<String> findAllBooksNotReleasedInYear(int releaseYear);

    List<String> findAllBooksReleasedBefore(LocalDate date);

    List<String> findAllBooksContaining(String containedString);

    List<String> findAllBooksWithAuthorsLastNameStartingWith(String startingLetters);

    int findBooksCountWithTitleSizeLongerThan(int number);


    List<String> findInformationOnBookTitle(String title);
}
