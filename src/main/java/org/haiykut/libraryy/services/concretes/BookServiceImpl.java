package org.haiykut.libraryy.services.concretes;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.haiykut.libraryy.entities.Book;
import org.haiykut.libraryy.entities.Category;
import org.haiykut.libraryy.repositories.BookRepository;
import org.haiykut.libraryy.repositories.CategoryRepository;
import org.haiykut.libraryy.services.abstracts.BookService;
import org.haiykut.libraryy.services.dtos.requests.book.AddBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.GetBookRequest;
import org.haiykut.libraryy.services.dtos.requests.book.UpdateBookRequest;
import org.haiykut.libraryy.services.dtos.responses.Book.AddBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.GetBookResponse;
import org.haiykut.libraryy.services.dtos.responses.Book.UpdateBookResponse;
import org.haiykut.libraryy.services.mappers.BookMapper;
import org.haiykut.libraryy.services.mappers.CategoryMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public String deleteById(int id) {
        bookRepository.deleteById(id);
        return "Silindi!";
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
        List<Book> books=bookRepository.findAll();
        List<GetBookResponse> bookResponses = new ArrayList<>();
        for (Book book : books) {
            GetBookResponse response = BookMapper.INSTANCE.bookFromResponse(book);
            bookResponses.add(response);
        }
        return bookResponses;
    }

    @Override
    public GetBookResponse getBookById(int id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Cant find a book of the related id!"));
        GetBookResponse response = BookMapper.INSTANCE.bookFromResponse(book);
        return response;
    }
}
