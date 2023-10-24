package bg.softuni.books_app.service;

import bg.softuni.books_app.model.dto.BookDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> findBookById(Long id);

    Long createBook(BookDTO bookDTO);

    void deleteBookById(Long id);
}
