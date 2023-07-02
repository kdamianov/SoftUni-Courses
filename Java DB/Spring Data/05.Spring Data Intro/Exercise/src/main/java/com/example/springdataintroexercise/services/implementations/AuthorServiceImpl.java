package com.example.springdataintroexercise.services.implementations;

import com.example.springdataintroexercise.models.Author;
import com.example.springdataintroexercise.repositories.AuthorRepository;
import com.example.springdataintroexercise.services.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHORS_FILE_PATH = "src/main/resources/files/authors.txt";
    private final AuthorRepository authorRepository; //

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    //creating a new record from each row of the text file
                    String[] fullName = row.split("\\s+");

                    Author author = new Author(fullName[0], fullName[1]);
                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        Long randomId = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        //--> method for generating random values
        return authorRepository.findById(randomId)
                .orElse(null);
    }

    @Override
    public List<String> getAllAuthorsOrderedByBooksCount() {
        return authorRepository
                .findAllByBooksSizeDesc()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .toList();
    }

}
