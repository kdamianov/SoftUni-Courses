package bg.softuni.books_app.web;

import bg.softuni.books_app.model.dto.BookDTO;
import bg.softuni.books_app.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){

        return ResponseEntity.ok(bookService.getAllBooks()); //трябва да върне HTTP status code 200
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> findBookById(@PathVariable("id") Long id) {
        Optional<BookDTO> optionalBookDTO = bookService.findBookById(id);

        return optionalBookDTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(
            @RequestBody BookDTO bookDTO,  //инструктураме Spring да deserialize DTO
             UriComponentsBuilder builder){ //клас, с който си извличаме URI

        long newBookId = bookService.createBook(bookDTO);

        return ResponseEntity
                .created(builder.path("/api/books/{id}").build(newBookId))
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable("id") Long id) {
        this.bookService.deleteBookById(id);

        return ResponseEntity.noContent().build(); //връща status code 204
    }

}
