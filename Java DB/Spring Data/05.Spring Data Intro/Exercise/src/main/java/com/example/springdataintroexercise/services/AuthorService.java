package com.example.springdataintroexercise.services;

import com.example.springdataintroexercise.models.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderedByBooksCount();
}
