package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.models.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksReleasedBeforeYear(int year);

    List<String> findAllBooksByAuthorsFirstAndLastNameByReleaseDateAndTitle(String firstName, String lastName);
}
