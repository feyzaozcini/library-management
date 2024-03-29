package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.repositories.BookRepository;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.repositories.MemberBookRepository;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.BookAddDto;
import org.haiykut.libraryy.services.dtos.BookUpdateDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final MemberBookRepository memberBookRepository;
    @Override
    public BookAddDto add(BookAddDto dto) {
        Book newBook = new Book();
        newBook.setName(dto.getName());
        newBook.setAuthor(dto.getAuthor());
        newBook.setPage(dto.getPage());
        newBook.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow(()-> new RuntimeException("Cant find a category of the related id!")));
        newBook.setBookCount(dto.getBookCount());
        bookRepository.save(newBook);
        return new BookAddDto(newBook.getName(), newBook.getAuthor(), newBook.getCategory().getId(),newBook.getPage(), newBook.getBookCount());
    }

    @Override
    public String deleteById(int id) {
        bookRepository.deleteById(id);
        return "Silindi!";
    }

    @Override
    public BookUpdateDto updateById(int id, BookUpdateDto dto) {
        Book requestedBook = bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Cant find a book of the related id!"));
        requestedBook.setName(dto.getName());
        requestedBook.setBookCount(dto.getBookCount());
        requestedBook.setPage(dto.getPage());
        requestedBook.setAuthor(dto.getAuthor());
        requestedBook.setCategory(categoryRepository.findById(dto.getCategoryId()).orElseThrow());
        bookRepository.save(requestedBook);
        return new BookUpdateDto(requestedBook.getName(), requestedBook.getAuthor(), requestedBook.getCategory().getId(), requestedBook.getPage(), requestedBook.getBookCount());

    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Cant find a book of the related id!"));
    }
}
