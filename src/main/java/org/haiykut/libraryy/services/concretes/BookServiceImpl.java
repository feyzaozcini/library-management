package org.haiykut.libraryy.services.concretes;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.repositories.BookRepository;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.haiykut.libraryy.services.mappers.BookMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public AddBookResponse add(AddBookRequest request) {
        Book savedBook = BookMapper.INSTANCE.bookFromRequest(request);
        bookRepository.save(savedBook);
        AddBookResponse response= new AddBookResponse(savedBook.getId(),savedBook.getName(),savedBook.getAuthor(),savedBook.getCategory().getId(),savedBook.getBookCount(),savedBook.getBookCount());
        return response;
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public UpdateBookResponse updateById(int id, UpdateBookRequest request) {
        Book book = BookMapper.INSTANCE.bookFromRequest(request);
        book.setId(id);
        bookRepository.save(book);
        UpdateBookResponse response=new UpdateBookResponse(book.getName(),book.getAuthor(),book.getCategory().getId(),book.getPage(),book.getBookCount());
        return response;
    }

    @Override
    public List<GetBookResponse> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> BookMapper.INSTANCE.responseFromBook(book)).collect(Collectors.toList());
    }

    @Override
    public GetBookResponse getBookById(int id) {
        return BookMapper.INSTANCE.responseFromBook(bookRepository.findById(id).orElseThrow(()->new RuntimeException("Cant find a book of the related id!")));
    }
}
