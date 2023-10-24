package bg.softuni.books_app.service.impl;

import bg.softuni.books_app.model.dto.AuthorDTO;
import bg.softuni.books_app.model.dto.BookDTO;
import bg.softuni.books_app.model.entity.AuthorEntity;
import bg.softuni.books_app.model.entity.BookEntity;
import bg.softuni.books_app.repository.AuthorRepository;
import bg.softuni.books_app.repository.BookRepository;
import bg.softuni.books_app.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {

        return this.bookRepository.findAll()
                .stream()
                .map(BookServiceImpl::mapToBookDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {

        return this.bookRepository.findById(id).map(BookServiceImpl::mapToBookDTO);
    }

    @Override
    public Long createBook(BookDTO bookDTO) {
        Optional<AuthorEntity> authorOpt = authorRepository
                .findByName(bookDTO.getAuthor().getName());

        BookEntity newBook = new BookEntity()
                .setAuthor(authorOpt.orElseGet(() ->
                        authorRepository.save(new AuthorEntity()
                                .setName(bookDTO.getAuthor().getName()))))
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        newBook = bookRepository.save(newBook);

        return newBook.getId();
    }

    @Override
    public void deleteBookById(Long id) {
        this.bookRepository.deleteById(id);
    }

    private static BookDTO mapToBookDTO(BookEntity bookEntity) {

        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setName(bookEntity.getAuthor().getName());

        return new BookDTO().setId(bookEntity.getId())
                .setTitle(bookEntity.getTitle())
                .setIsbn(bookEntity.getIsbn())
                .setAuthor(authorDTO);
    }
}
